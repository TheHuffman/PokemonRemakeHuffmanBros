The Huffman Pokemon Recreation Project:

Some basic commands to help you out in case you forget
  - To compile use sbt compile
  - To run the game, use sbt run
  - To push your changes to git
    > git add *
    > git commit -m "some text about your changes"
    > git push
    > fill in login info

Basic Scala
  - For Loops are as such: for(i <- # to #) {code} (Remember, things are 0 indexed)
    > (i <- 0 until array.size) will go through a whole Array
    > to goes up to and includes, until goes up till

  - While Loops are simple: while(condition) {code}
  - If statements: if(condition) {code} else if(condition) {code} else {code} (These also return a value, so you can use them in assignment)
  - Arrays are a thing: var name: Array[Type] = new Array[Type](array length) (Values initialized to null if not an Int)
    > example of using an array and accessing with for loop:
    for(i <- 0 until pokemon.size) {
      pokemon(i) = null
    }
    where i is the index of the array

I think that is the important stuff, if there is anything else you want me to put here just let me know.
