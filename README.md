# CParser Web Demo
[CParser](https://github.com/gropple/CParser) is my project that parses the C language into a clean abstract syntax tree that you can use in your JVM project.  This is both a ScalaJS compiled widget version of that which can be embedded on a website, and a handy example of how to walk the AST and do something with it - in this case, converting it back into C.

I've separated this out from the main CParser projects so that has no dependencies on ScalaJS.

## What It Does
The included index.html will load the Javascript (this is a Scala project, but it's transpiled to Javascript with ScalaJS) and display both a code editor (using the excellent Ace library), and output tabs.

The code editor takes any valid C code, and the output tabs display either:

* The abstract syntax tree corresponding to that C code, or
* C code that's been generated from that abstract syntax tree.  It should look very similar to the original C, bar a few unimportant whitespace and semicolon changes.

You might be wondering what's the point of converting C back to C, and well, in practical terms - not much.  But it is a very useful way of checking that CParser works.

## Understanding the Code
Take a look at CGenerator.  You can start from 'generateTop', which starts at the root of the AST, and follow it all the way down.  It follows the [C language specification](https://port70.net/~nsz/c/c11/n1570.html#A) very closely so I haven't included any additional docs.  I'm assuming that anyone needing a C AST is going to be pretty comfortable reading the spec, and it should be fairly intuitive what's going on here.

Note that CGenerator is functionally pure and so doesn't have any side effects.  Instead it outputs a bunch of 'Generated'.  These are simple commands to output strings, increase and decrease newline levels, that kind of thing.  They are executed by 'CGeneratedPrinter'.

## Use
This is really only intended to be used on my [personal site](https://gropple.github.io/Words/projects/), and as an example of how to use CParser.

But, if you want to play with it:

Follow the [CParser](https://github.com/gropple/CParser) instructions.

* cd <some_location>
* Clone this project into CParserWebDemo.
* Clone the CParser project into CParser.  (CParserWebDemo is setup to look for ../CParser).
* sbt fastOpt.
* Open src/main/resources/index.html.

## Contributing

Please feel free to send PRs!

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

