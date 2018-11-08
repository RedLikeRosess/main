import socket
import struct

connection = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_address = ('localhost', 11111)

connection.connect(server_address)
while True:
	message = raw_input('What do you want to do?\n' + 'exit or count?\n')
	if message == 'count':
		values = (int(raw_input()), str(raw_input()), int(raw_input()))
		packer = struct.Struct('I 1s I')
		packed_data = packer.pack(*values)
		connection.sendall(packed_data)
		data = connection.recv(1024)
		print data
	else:
		connection.close()
		break