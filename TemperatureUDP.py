import socket

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

print("1. Server  2. Client")
choice = input("Enter choice: ")

if choice == "1":
    s.bind(("localhost", 5001))
    print("Server waiting for temperature...")

    data, addr = s.recvfrom(1024)
    print("Temperature received:", data.decode())

else:
    temp = input("Enter temperature: ")
    s.sendto(temp.encode(), ("localhost", 5001))
    print("Temperature sent successfully")

s.close()