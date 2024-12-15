import hashlib
import itertools
import subprocess
import base64
import math

class Streamer:
    def __init__(self, seed="01101000010", tap=8):
        self.lfsr = [False if bit == '0' else True for bit in seed]
        self.tap = (len(seed) - 1) - tap

    def step(self):
        new_bit = self.lfsr[self.tap] ^ self.lfsr[0]
        for i in range(len(self.lfsr) - 1):
            self.lfsr[i] = self.lfsr[i + 1]
        self.lfsr[-1] = new_bit
        return 0 if not new_bit else 1

    def g2(self):
        val = 0
        for i in range(16):
            val |= self.step() << i
        return val

    def generate(self, k):
        temp = 0
        for i in range(k):
            temp = (temp * 2) + self.step()
        return temp

    def __str__(self):
        representation = ''.join(['1' if bit else '0' for bit in self.lfsr])
        return representation


class Upos:
    def __init__(self):
        init_vector = [byte + 128 for byte in [-34, -83, -66, -17, -34, -83, -66, -17, -34, -83, -66, -17, -34, -83, -66, -17]]
        self.init_vector = bytearray(init_vector)
        # print(sum_array)

    def main(self):

        characters = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_!?-.|~`@#$%^&*(+=-)'

        
        m = [[0] * 256 for _ in range(256)]
        instance = Upos()
        instance.lm(m)

        
        idx16 = 100

        ip_bool = [Upos.ip(i2) * i2 for i2 in range(30)]

        print(f"ip_bool {ip_bool}")

        sum_array = [sum(ip_bool[:i+1]) + 12 for i in range(len(ip_bool))]
        for i in range(30):
            sum_array[i] = sum_array[i] + 32 * i
        print(f"sum_array {sum_array}")



        # s = Streamer()
        # for _ in range(12):
        #     s.step()
        flag = ""


        for i2 in range(30):
            print(f"round {i2}")

            for combination in itertools.product(characters, repeat=2):
                curr = ''.join(combination)

            # curr = core[i2 * 2:i2 * 2 + 2]
            
                # if Upos.ip(i2):
                #     for j in range(i2):
                #         s.step()
                s = self.streamer_step(i2, sum_array)
                j2 = s.g2()
                # print(f"j2 {j2}")
                mX = j2 & 255
                # print(f"mX {mX}")
                mY = (s.g2() & 0xFF00) >> 8
                # print(f"mY {mY}")
                # print(f"correct String {Upos.sq(Upos.r(curr))} {m[mX][mY]}")
                if Upos.sq(Upos.r(curr)) == m[mX][mY]:
                    print(f"correct String {i2} {curr}")
                    flag = flag + curr
                else:
                    idx16 += 1
        
        print(f"flag {flag}")

        # for combination in itertools.product(characters, repeat=2):
        #     curr = ''.join(combination)

        #     flag = 'MOBISEC{Isnt_this_a_truly_evil_undebuggable_piece_of_s' + curr + 'W_software??}'

        #     if self.h(flag) == "4193d9b72a5c4805e9a5cc739f8a8fc23b2890e13b83bb887d96f86c30654a12":
        #         print(f"flag {flag}")
        #         return
            


# MOBISEC{Isnt_this_a_truly_evil_undebuggable_piece_of_sh^W_software??}
           
    def streamer_step(self, i, sum_array):
        s = Streamer()
        round_number = sum_array[i]
        for _ in range(round_number):
            s.step()
        
        return s



    @staticmethod
    def ec(cmd):
        out = ""
        try:
            process = subprocess.Popen(cmd, stdout=subprocess.PIPE, shell=True)
            stdout, _ = process.communicate()
            out = out + stdout.decode("utf-8")
        except Exception as e:
            pass
        return out

    @staticmethod
    def r(s):
        out = ""
        for c in s:
            if 'a' <= c <= 's' or 'A' <= c <= 'S':
                c = chr(ord(c) + 7)
            elif 't' <= c <= 'z' or 'T' <= c <= 'Z':
                c = chr(ord(c) - 19)
            out = out + c
        return out

    @staticmethod
    def ip(x):
        for i in range(2, x):
            if x % i == 0:
                return False
        return True

    @staticmethod
    def sq(a):

        n = (ord(a[0]) + (ord(a[1]) << 8)) & 0xFFFF
        n2 = pow(n, 2)
        return n2


    def h(self, flag):
        try:
            md = hashlib.sha256()
            md.update(flag.encode())
            digest = md.digest()
            return self.th(digest)
        except Exception as e:
            return None

    def th(bytes):
        hex_string = ''.join(format(b, '02x') for b in bytes)
        return hex_string


    def lm(self, matrix):
        try:
            with open("lotto.dat", "r") as file:
                rowIdx = 0
                for line in file:
                    elems = line.split()
                    colIdx = 0
                    for elem in elems:
                        e = int(elem)
                        matrix[rowIdx][colIdx] = e
                        colIdx += 1
                    if colIdx != 256:
                        raise Exception("Error")
                    rowIdx += 1
                if rowIdx != 256:
                    raise Exception("Error")
        except Exception as e:
            # Handle exception (e.g., print an error message)
            raise e


    @staticmethod
    def dec(x):
        return base64.b64decode(x).decode("utf-8")


if __name__ == "__main__":
    upos_instance = Upos()
    upos_instance.main()
