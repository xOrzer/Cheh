main <- function(){
  setwd("~/Documents/Verel/Nahui/data05")
  
  #read data from file	
  df.hc <- read.table("hc_3.dat", header = TRUE, sep = "")
  
  #compute mean for each search space id
  #df.perf <- summaryBy(fitness ~ id, data = df.hc)
  fitness.mean <- c()
  for (i in 0:59){
    fitness.mean <- c(fitness.mean, mean(df.hc[df.hc$id == i,]$fitness))
  }
  #save into data frame
  df.perf <- data.frame(id = 0:59, fitness.mean = fitness.mean)
  hist(df.hc[df.perf$id == 8,]$fitness)
  hist(df.hc[df.perf$id == 41,]$fitness, add = TRUE, col = "red")
}

