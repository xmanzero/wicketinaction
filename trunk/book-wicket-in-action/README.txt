Wicket in Action
================

This project is the companion examples project to the Wicket in Action book.
The code is licensed under the Apache Software License 2.0 and available from
Google code hosting.

In this document you will find the following information:

 - about the book 
 - about Apache Wicket 
 - about the examples 
 - downloading the examples 
 - running the examples

About the book

About Apache Wicket

About the examples

These examples have been created with two ideas in mind:

1. the examples have to look good 2. the examples need to be understandable

In order to satisfy both these ideas we have used Wicket's markup inheritance
to create a consistent layout, as is explained in chapter 8 of our book.

This boils down to the situation where we define our layout for all pages in
our examples in a base page, called AbstractBasePage. This page defines the
layout, and adds a basic menu to each page, linking to the main content of
these examples. Each example page extends the AbstractBasePage and provides
the components for the examples of the particular section. The markup of each
example page is wrapped inside <wicket:extend> tags.

So if you want to see the examples' code in isolation, please take a look at
the actual source code, instead of what is rendered inside your browser.

Downloading the examples

You can download the examples from the Wicket in Action google code project,
found at:

 http://wicketinaction.googlecode.com

Running the examples

The examples require the following prerequisites in order to run: 

 - Java 5 or newer 
 - a servlet container supporting Servlet api 2.4 or newer (Tomcat 5+, Jetty
   5+, etc.)

The examples can be run by deploying the wicketinaction.war into the servlet
container of your choice. Usually by copying it into the webapps directory.
