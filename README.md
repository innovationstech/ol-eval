# ol-eval

A Clojure library designed as a solution to an excercise.

There are two main (known) problems with this solution:

1. do is called on each expression using a case statement, and the statements within the do call are overly hardcoded for the tests. This makes the code brittle and unable to accept more than two expressions. The excercise document showed elipses in the macro form, which seemed to indicate that acceptance of a variable number of expressions was desired. Several things were tried to call do (doseq, etc) on a sequence to allow this, but with no solutions that worked for all test cases.
2. Test 7 (core_test.clj) is commented out due to difficulties getting it to work properly. That test condition was checked manually.

## Usage

The tests can be run using

```
lein test
```

The macro is in core.clj and the tests are in core_test.clj.

## License

Copyright © 2014 jwright

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
