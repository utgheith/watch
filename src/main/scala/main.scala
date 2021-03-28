object main {

  def logger(what: String, data: Any) = {
      val d = data match {
          case a:Array[_] => a.toList.toString
          case x => s"${x} : ${x.getClass.getName}"
      }
      println(s"$what $d")
  }

  def main(args: Array[String]): Unit = {
    val data = os.pwd / "data"

    os.remove.all(data)

    os.makeDir(data)
    os.makeDir(data / "a")
    os.makeDir(data / "b")
    os.write(data / "a" / "f", "f")
    os.write(data / "b" / "g", "g")

    os.watch.watch(Seq(data), println, logger)

    os.remove.all(data)

    Thread.sleep(1000000)
  }

}
