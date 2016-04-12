package simple

import breeze.linalg._
import breeze.numerics._
import breeze.plot._
import breeze.stats._
import java.awt.{Color, Paint}
import java.io.File
import scala.io.Source

object Algorithm {
    // Parameters.
    val k = 7 // K'th neighbor used in local scaling.
    val minClusters = 2 // Minimal number of clusters in the dataset.
    val maxClusters = 6 // Maximal number of clusters in the dataset.
    val eps = 2.2204e-16

    def main(args: Array[String]) = {
        // Choose the dataset to cluster.
        val pathToMatrix = getClass.getResource("/4.csv").getPath()
        val matrixFile = new File(pathToMatrix)

        // Create a DenseMatrix from the CSV.
        val originalMatrix = breeze.linalg.csvread(matrixFile)

        val f = Figure()
        val p = f.subplot(0)
        // val m = DenseMatrix.rand(200,200)
        // println(m)
        // p += image(m)
        p += scatter(originalMatrix(::, 0), originalMatrix(::, 1), {(_:Int) => 0.3}, {(_:Int) => Color.BLACK})

        p.title = "Tesselation tree"
        f.saveas("image.png")
    }
}
