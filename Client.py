# Oleg krasauchik
import socket; import select; import sys;

client_sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client_sock.connect(('localhost',12345))
while True:
	direct = '  DIR/dir - to get the content of actual folder'
	find = '  FIND/find <filename> - to get info exist file or does not'
	dl = '  DL/dl <filename> - download file with name <originalfilename_downloaded>'
	exit = '  EXIT/exit - tdisconnects from the server'
	message = raw_input('  What do you want to do?\n' + direct + '\n' + find + '\n' + dl + '\n' + exit + '\n' + 'Input: ')
	action = ''.join(message.split(' ', 1)[:1])
	file = ''.join(message.split(' ', 1)[1:])
	if action == 'EXIT' or action == 'exit':
		client_sock.close()
		break
	elif action == 'DL' or action == 'dl':
		client_sock.sendall(message)
		choice = client_sock.recv(1024)
		if choice == "File doesn't exist":
			print choice
		else:
			print choice
			while True:
				fileData = client_sock.recv(1024)
				name = ''.join(file.split('.', 1)[:1]) # 1 Create
				extension = ''.join(file.split('.', 1)[1:]) # 2 new
				newName = name + '_downloaded.' + extension # 3 file name
				downloadedFile = open(newName,"wb")
				while fileData:
					downloadedFile.write(fileData)
					fileData = client_sock.recv(1024)
				print "Download Completed"
				client_sock.close()
	else:
		client_sock.sendall(message) 
		print client_sock.recv(1024) 
	