f <- function(x) {
  return((x[1] - 3)^2 + (x[2] - 1)^2)
}

gradientf <- function(x) {
  y <- c(2*(x[1] - 3), 2*(x[2] - 1))
  return(y)
}

f2 <- function(x) {
  return( -x^3+x^2-2*x+5)
}

df2 <- function(x) {
  return(-3*x^2+2*x-2)
}

newton <- function(f, df, x0, precision) {
  x <- x0
  
  while(abs(f(x)) > precision){
    x <- x - f(x) / df(x)
  }
  return(x)
}

descenteGradient <- function(f, gradf, sigma, precision, x) {
  success <- FALSE
  dynamique <- c()
  while(!success) {
    w <- -(gradf(x))
    x <- x + sigma*w
    success <- abs(f(x)) < precision
    dynamique <- c(dynamique, f(x))
  }
  return (list("xmin"=(x),"dynamique"=(dynamique)))
}

mainNewton <- function() {
  x0 <- 0
  x <- newton(f2, df2, x0, 0.01)
  cat(x, f2(x), "\n")
}

main <- function() {
  x <- c(100,20)
  
  values <- descenteGradient(f, gradientf, 0.1, 10^-7,x)
  cat(values$xmin,"\n",f(values$xmin),"\n")
  
  
  plot(values$dynamique)
}


mainNewton()