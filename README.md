Quotations By Casey Harford
=================================

COMPILE INSTRUCTIONS - IMPORTANT
=================================
I've included a pre-built "jar" file in the dist folder. Execute like so:

	java -jar dist/Quotations.jar
	
I tried out something new for this assignment. Normally, I use VI, for just
about everything. This was my first experience with NetBeans. I started out
with a basic table, and a couple of commands, and built off of that. I found
it was very convenient to have a "design" view, something not possible with VI.

The problem that I ran into, is this assignment seems to only compile on a
computer with NetBeans installed. I tried compiling on alternate computers,
without NetBeans installed and they failed miserably. I can assure you, this
code compiles, with all the required dependencies. I have tested the jar on
multiple systems, and it works great. Once you attempt to compile, however,
it will not work. So please, run the program with included jar.

If you'd like to try compiling, here are the two ways:

	1)	Open project in NetBeans, and build it from there.
	
	2)	Command line utility: ant
	
		ant
		
		Run the above command "ant" within the root directory of the project.
		This will build the project, and creates a Quotations.jar file in the
		dist folder.
		
Instructions
=================================
A user who is not logged in has the ability to view quotes, search quotes,
and sort quotes. Functions such as new, delete(depends on DB permissions),
save, and update, are only allowed once a user has logged in. From main menu
a user can click sign up, to register as a new user. Clicking Login, will
display a login screen, allowing user to login.

Search function works by filtering results in the table. Currently, the radio
buttons do not affect the search. I was unable to restrict which column was
being searched. At the moment, the search does work, however it searches every
column. 

To create a new Quote, click New. A quote will be added to the list, but it will
not be saved, until the user presses Save. Fill in details for quote, then Save 
it. At this point, the data base is updated.

My Experiences
=================================
This was not my first time working with MySQL. I was however, a newbie when it 
came to Java and MySQL. I caught on quickly, and the format of setting up the
connection, and doing query's was similar to past languages that i've used.

The most difficult part for me was the user interface. I am very confident at
the background work, but what is displayed is where I have problems. I'm 
still getting familiar with Java's Swing way of doing things. I am more used
to Web Application interfaces, with HTML/CSS, and not Java. Now that i've
gotten this experience with Java, I hope to use it more, and do things with
it that in the past were not possible. 