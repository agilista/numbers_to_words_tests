## The Polyglot Challenge ##

The challenge is to write some code to convert numbers to their british english numeral equivalent using the least
amount of legitimate lines of code in any language (as long as it can be shown to execute).
i.e. 1 as one, 101 as one hundred and one, 900090 as nine hundred thousand and ninety.

We've bundled some tests with this check-in, so it isn't too important that you know british english numerals.
As long as you have java installed, and you can run junit, you can run these tests and verify your code.

The definition of english numerals can be found at:
http://en.wikipedia.org/wiki/English_numerals

The session is 3 hours long.  Please refer to the rules below.



### Rules ###

* We'll be using intellij to format each person's code using the defaults from when you code format (alt + cmd + l).
**  If the code would naturally have a line break this should be put in place (i.e. return "fish"; in js should have a
    line break at the end)

* If the line goes over 80 characters, a forfeit of a new line per character will be introduced.

*   If any libs are linked to, _all_ of the source from that library should also be included, with any subsequent
    linking, as they will all also be counted as lines of code.  Any build files, html files etc will also be included.

Every participant should stick to the spirit of the rules and not the letter.
If you're unsure whether you'll fall foul of competition rules, shout about it :o)

If it comes down to a draw with equal line numbers, the prettiest code (decided by participants voting) will win.

There will also be runners up for elegant code solutions.




### How To Use The Bundled Tests ###

The tests are run by loading in all the values from the expected file and the actual file.
Either produce the actual file programmatically, or copy and paste from your console into this file.
The format is:

> number=numeral\n


e.g.


> 9001=nine thousand and one


Any fails should hopefully be pretty self explanatory.