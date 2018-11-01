import socket; import select; import os; import shutil; import sys; from functools import partial;

def exist(file): # procedure for checkin the existence of a file 
	result = []
	for root, dirs, files in os.walk(directory):
		if file in files:
			result.append(os.path.join(root, file))
	return result

serv_sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
serv_sock.bind(('localhost',12345))
serv_sock.listen(1)
inputs = [ serv_sock ]
outputs = [ ]
timeout = 1
while True:
	readable, writable, exceptional = select.select(inputs, outputs, inputs, timeout)
	for s in readable:
		if s is serv_sock:    #new client connect
			connection, client_address = serv_sock.accept()
			print('New client from %s:%d' % client_address)
			inputs.append(connection)
		else:
			data = s.recv(1024)
			directory = os.path.dirname(os.path.abspath("Server.py")) # The path to the server folder
			searching = '\n'.join(os.listdir(directory))
			action = ''.join(data.split(' ', 1)[:1]) # reading action
			file = ''.join(data.split(' ', 1)[1:]) # reading file
			if action == "DIR" or action == "dir":
				s.sendall(searching)
			elif action == "DL" or action == "dl":
				if exist(file) == []:
					s.sendall("File doesn't exist")
				else:
					s.sendall("File exists")
					with open(directory + '/' + file,"rb") as openfileobject:
						for chunk in iter(partial(openfileobject.read, 1024), b''):
							s.sendall(chunk)
							chunk = open(directory + '/' + file,"rb").read(1024)
					print "Sending Completed"
					s.close()
					inputs.remove(s)
			elif action == "FIND" or action == "find":
				if exist(file) == []: # check existence of file
					s.sendall("False")
				else:
					s.sendall("True")
			else:
				s.close()
				inputs.remove(s)					