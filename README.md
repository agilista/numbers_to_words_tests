## The Polyglot Challenge ##

The challenge is to write code that will convert numbers to their british english numeral equivalent using the least
amount of legitimate lines of code in any programming language (as long as lines of code can be counted and it can be
shown to execute).
i.e. 1 as one, 101 as one hundred and one, 900090 as nine hundred thousand and ninety.

We've bundled some tests with this check-in, so it isn't too important that you know british english numerals.
As long as you have java installed, and you can run junit, you can run these tests and verify your code.

The definition of english numerals can be found at:
http://en.wikipedia.org/wiki/English_numerals

The session is 3 hours long, which means 2 1/2 hours of coding.  Please refer to the rules below.



### Rules ###

* You can take up the challenge individually or as a group.  Groups shouldn't really be larger than 5 people

* We'll be using intellij to format each person or groups code using the defaults from when you code format
  (alt + cmd + l).

    *   If the code would naturally have a line break this should be put in place (i.e. return "fish"; in js should have a
        line break at the end)

* If the line goes over 80 characters, a forfeit of a new line per character will be introduced.

*   If any libs are linked to, _all_ of the source from that library should also be included, with any subsequent
    linking, as they will all also be counted as lines of code.  Any build files, html files etc will also be included.

Every participant should stick to the spirit of the rules and not the letter.
If you're unsure whether you'll fall foul of competition rules, shout about it :o)

If it comes down to a draw with equal line numbers, the prettiest code (decided by participants voting) will win.

There will also be runners up for elegant code solutions.



### How to Run The Tests ###

Clone this repo then:

> cd dist

> sh ./run_me.sh

You should see a number of tests legitimately fail, as the actual_values.properties file does not contain the same
values as the expected_values.properties

If this doesn't work for you, you may have to recompile the source.
cd to the root of the project and:

> ant




### How To Use The Bundled Tests ###

The tests are run by loading in all the values from the expected_values.properties file and the actual_values.properties
file.
Either produce the actual_values.properties file programmatically, or copy and paste from your console into this file.

The format is:

> number=numeral\n


e.g.


> 9001=nine thousand and one


Any fails should hopefully be pretty self explanatory.



### How to Run The Line Counter ###

Clone this repo then:

> cd dist

> sh ./count_me.sh _dir_

i.e.

> sh ./count_me.sh ../

p.s. this command for this project should be 738 lines :o)

This will run against the directory or file pointed to.  The code will recurse over the directory and, with the
exception of the excluded files and extensions, will count everything.

If this doesn't work for you, you may have to recompile the source.
cd to the root of the project and:

> ant




### How To Use The Line Counter ###

The line counter is run by loading in exclusions for extensions and files (in the excluded_extensions.txt and
excluded_files.txt files)

If you need to add another extension or file to exclude, please ask to see if its reasonable.  Auto-generated class
files for typed languages compiling into the same root folder are ideal candidates for exclusion
