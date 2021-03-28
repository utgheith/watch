object main {

  val LOG = false

  def logger(what: String, data: Any) : Unit = {
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
    paths.map(_.relativeTo(os.pwd)).foreach { p => println(s"  $p")}
  }

  def main(args: Array[String]): Unit = {
    val data = os.pwd / "data"

    os.remove.all(data)
    os.makeDir.all(data / "a")
    os.makeDir.all(data / "b")

    os.watch.watch(Seq(data), printer, logger)

    os.remove.all(data)

    Thread.sleep(5000)
  }

}
