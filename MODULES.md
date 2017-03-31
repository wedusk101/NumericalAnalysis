# NumericalAnalysis

MODULES
-------

This is a tentative outline of the required modeuls for the package. Obviously, they are subject to change.
Related dependencies are marked accordingly. Please update this file as you see fit.

Text Parsing / Input Recognition
--------------------------------

This is the most important module as this can be designed and implemented in various ways.I wonder if we could
use something like TeX where we could use special symbols for recognizing the desired input of the user.
For e.g. Integrate Sin x dx over 0 to pi/3 could be expressed as : $ISin$x#dx#0,pi/3
Here, each math operation is separated by a $. Order of precedence and associativity needs to implemented for some 
functions. The values enclosed within # imply the differential over here followed by the interval. 

Root Finding Methods
--------------------

Newton - Raphson (Depends on calcDerivative, calcError)
Regula Falsi(Depends on calcError)

Systems of Linear Equations
---------------------------

Gauss-Siedel(Depends on calcError)

Numerical Integration
---------------------

Trapezoid Rule(Depends on calcError)
Simpson's one-third(Depends on calcError)

Constants and Transcendental Numbers 
------------------------------------

Taylor and Maclaurin Expansions (Depends on calcDerivative)
Important mathematical constants could be used from the java Math class.
e.g. e, pi, phi, tao.

Implementation Functions
------------------------

calcDerivative - Calculates the derivative of a function at a point. Non-symbolic as of now. We could consider 
automatic differentiation or symbolic methods later on.

calcError - Calculates the error after each itertation of the relevant algorithms. This function will be heavily
customized and overridden depending on the use case. 



