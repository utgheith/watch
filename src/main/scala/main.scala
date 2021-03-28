object main {

  val LOG = false

  def logger(what: String, data: Any) = {
    if (LOG) {
      val d = data match {
        case a: Array[_] => a.toList.toString
        case x => s"${x} : ${x.getClass.getName}"
      }
      println(s"$what $d")
    }
  }

  def printer(paths: Set[os.Path]): Unit = {
    println("event")
    paths.foreach { p => println(s"  $p")}
  }

  def main(args: Array[String]): Unit = {
    val data = os.pwd / "data"

    os.remove.all(data)

    os.makeDir(data)
    os.makeDir(data / "a")
    //os.makeDir(data / "b")
    //os.write(data / "a" / "f", "f")
    //os.write(data / "b" / "g", "g")

    //println("giving the file system time to settle")
    //Thread.sleep(5000)

    //println("watching")
    os.watch.watch(Seq(data), printer, logger)

    //println("removing")
    os.remove.all(data)

    Thread.sleep(5000)
  }

}
