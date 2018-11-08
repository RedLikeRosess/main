import socket
import struct
import select
import random

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_address = ('localhost', 11111)
sock.bind(server_address)
sock.listen(1)

inputs = [sock]
outputs = []
timeout=1
values = []
dictEx = {}
while True:
	readable, writable, exceptional = select.select(inputs, outputs, inputs, timeout)
	for s in readable:
		if s is sock:    
			connection, client_address = sock.accept()
			print('New client from %s:%d' % client_address)
			inputs.append(connection)
		else:
			data = connection.recv(1024)
			if data:
				if len(dictEx.values()) == 5:
					delete = random.randint(0,4)
					dictEx.pop(list(dictEx.keys())[delete])
				unpacker = struct.Struct('I 1s I')
				unpacked_data = unpacker.unpack(data)
				temp = ''
				for i in range(3):
					temp = temp + str(unpacked_data[i])
				if temp in dictEx:
					data = dictEx[temp]
					print 'from memory\n' + data
					connection.sendall(data)
				else:
					connect = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
					server_address = ('localhost', 22222)
					connect.connect(server_address)
					connect.sendall(data)
					data = connect.recv(1024)
					print 'counted value\n' + data
					dictEx[temp] = data
					connection.sendall(data)
			else:
				connection.close()
				inputs.remove(connection)