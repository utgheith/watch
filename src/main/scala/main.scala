object main {

  def main(args: Array[String]): Unit = {
    import scala.collection.mutable


    val data = os.pwd / "data"

    os.remove.all(data)

    val changed = mutable.Set[os.Path]()

    def onChange(s : Set[os.Path]): Unit = {
      println(s)
      changed.addAll(s)
    }

    //os.watch.watch(Seq(data), onChange, (_,_) => {})

    os.makeDir(data)
    os.makeDir(data / "a")
    os.makeDir(data / "b")
    os.write(data / "a" / "f", "f")
    os.write(data / "b" / "g", "g")

    println("waiting for create")

    //while (changed.size != 5) {
      //println(s" ${changed.size}")
    //  Thread.sleep(1)
    //}
    //println("all created")

    //Thread.sleep(1000)

    //changed.clear()

    os.watch.watch(Seq(data), onChange, (_,_) => {})

    os.remove.all(data)

    //println("waiting for remove")

    //while (changed.size != 5) {
    //  Thread.sleep(1)
    //}
    //println("all removed")

    Thread.sleep(1000000)

  }

}
