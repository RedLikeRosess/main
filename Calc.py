import socket
import struct

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

server_address = ('localhost', 22222)
sock.bind(server_address)

sock.listen(1)
while True:
	connection, client_address = sock.accept()
	#print "New connection from: "
	#print client_address
	data = connection.recv(1024)
	unpacker = struct.Struct('I 1s I')
	unpacked_data = unpacker.unpack(data)

	reply = eval(str(unpacked_data[0]) + str(unpacked_data[1]) + str(unpacked_data[2]))

	connection.sendall(str(reply))
	connection.close()