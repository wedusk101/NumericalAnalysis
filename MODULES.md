# NumericalAnalysis

MODULES
-------

This is a tentative outline of the required modules for the package. Obviously, they are subject to change.
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

Newton - Raphson (Depends on calcDerivative, calcError, Polynomial)
Secant Method(Depends on calcError, Polynomial)
Bisection Method(Depends on calcError, Polynomial)
Regula Falsi(Depends on calcError, Polynomial)

Systems of Linear Equations
---------------------------

Gauss-Siedel(Depends on calcError)

Numerical Integration
---------------------

Trapezoid Rule(Depends on calcError, Polynomial)
Simpson's one-third(Depends on calcError, Polynomial)

Constants and Transcendental Numbers 
------------------------------------

Taylor and Maclaurin Expansions (Depends on calcDerivative)
Important mathematical constants could be used from the java Math class.
e.g. e, pi, phi, tau etc.

Differential Equations
----------------------

Initially we intend on implementing ODE only. Later on we hope to extend the
functionality to PDE.For ODEs we will have

Euler's Method
Runge-Kutta 

Interpolation Methods
---------------------

Linear Interpolation
Lagrangian Interpolation
Newton's Interpolation
Forward / Backward Interpolation(Depends on calcFiniteDifference)

Implementation Functions
------------------------

calcDerivative - Calculates the derivative of a function at a point. Non-symbolic as of now. We could consider 
automatic differentiation or symbolic methods later on.

calcError - Calculates the error after each itertation of the relevant algorithms. This function will be heavily
customized and overridden depending on the use case. 

calcFiniteDifference - This method is used to calculate the finite difference table for the
interpolation modules. Since the finite difference is basically the discrete analog of the
derivative, this method could also be used for the calcDerivative method.

Class Polynomial - This class is used for the creation of a polynomial object. It also contains a methos polyEval()
used for calculating the value of a polynomial for a particular value of x.

Testing Modules
---------------

We intend on implementing two different testing modules. One automated testing module and one black box testing function.
This module is extremely important using which we will considering various scenarios and make sure that the package 
is robust and reliable.



