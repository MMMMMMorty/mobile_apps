import math
from Crypto.Cipher import AES
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import padding
import hashlib

BS = 8
pad = lambda s: s + (BS - len(s) % BS) * chr(BS - len(s) % BS) 

def main():
    hex_string = "0eef68c5ef95b67428c178f045e6fc8389b36a67bbbd800148f7c285f938a24e696ee2925e12ecf7c11f35a345a2a142639fe87ab2dd7530b29db87ca71ffda2af558131d7da615b6966fb0360d5823b79c26608772580bf14558e6b7500183ed7dfd41dbb5686ea92111667fd1eff9cec8dc29f0cfe01e092607da9f7c2602f5463a361ce5c83922cb6c3f5b872dcc088eb85df80503c92232bf03feed304d669ddd5ed1992a26674ecf2513ab25c20f95a5db49fdf6167fda3465a74e0418b2ea99eb2673d4c7e1ff7c4921c4e2d7b"
    original_bytes = bytes.fromhex(hex_string)
    # print(original_bytes)
    byte_range = bytes(range(256))

    for a in byte_range:
        for b in byte_range:
            for c in byte_range:
                
                # print(key_str)
                try:
                    full_key = bytes([a, b, c])
                    digest = hash_function(full_key)
                    key = bytes([digest[0], digest[ math.floor(len(digest)/2)], digest[-1]])
                    curr_key = hash_function(key)

                    intermediate_keys = [curr_key for _ in range(10)]

                    for i in range(10):
                        intermediate_keys[i] = curr_key
                        curr_key = hash_function(curr_key)
                    

                    one = decrypt(original_bytes, intermediate_keys[9])
                    two = decrypt(one, intermediate_keys[8])
                    three = decrypt(two, intermediate_keys[7])
                    four = decrypt(three, intermediate_keys[6])
                    five = decrypt(four, intermediate_keys[5])
                    six = decrypt(five, intermediate_keys[4])
                    seven = decrypt(six, intermediate_keys[3])
                    eight = decrypt(seven, intermediate_keys[2])
                    nigh = decrypt(eight, intermediate_keys[1])
                    ten = decrypt(nigh, intermediate_keys[0])

                    # new_ten = unpad_bytes(ten)

                    # print(ten)
                    if ten.startswith(b"MOBISEC"):
                        print(full_key)
                        print(ten)
                        print(ten.decode())
                        return
                except Exception as e:
                    print(e)
def to_hex(byte_array):
    hex_string = ''.join(["{:02x}".format(b) for b in byte_array])
    return hex_string

def from_hex(hex_string):
    return bytes.fromhex(hex_string)

def decrypt(in_bytes, key):
    cipher = AES.new(key, AES.MODE_ECB)
    padded_data = cipher.decrypt(in_bytes)
    return padded_data

def unpad_bytes(data):
    padding_length = data[-1]
    unpadded_data = data[:-padding_length]
    return unpadded_data

def pkcs7_padding(data, block_size):
    pad_length = block_size - len(data) % block_size
    padded_data = data + bytes([pad_length] * pad_length)
    return padded_data

# def decrypt(data, key):
#     backend = default_backend()
#     cipher = Cipher(algorithms.AES(key), modes.ECB(), backend=backend)

#     decryptor = cipher.decryptor()
#     decrypted_data = decryptor.update(data) + decryptor.finalize()

#     unpadder = padding.PKCS7(algorithms.AES.block_size).unpadder()
#     unpadded_data = unpadder.update(decrypted_data) + unpadder.finalize()

#     return unpadded_data

def hash_function(in_bytes):
    md5 = hashlib.md5()
    md5.update(in_bytes)
    return md5.digest()

if __name__ == "__main__":
    main()
