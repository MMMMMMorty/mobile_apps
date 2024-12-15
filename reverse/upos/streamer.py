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

def main():
    lfsr = Streamer()
    print("Testing step()")
    for _ in range(10):
        bit = lfsr.step()
        print(f"{lfsr} {bit}")

    lfsr2 = Streamer()
    print("\nTesting generate()")
    for _ in range(10):
        r = lfsr2.generate(5)
        print(f"{lfsr2} {r}")

if __name__ == "__main__":
    main()
