import java.io.File
import java.io.FileReader

object SqlReader{
    // Regex of keywords to search sql file for.
    val keywords = List("^Name", "^Description", "^Type", "^Default", "^Required", "^Example", "^Notes")
    var cliOptiosn = ""

    // Read the file and return it as a string
    def readFile(file:String):String = {
      val source = scala.io.Source.fromFile(file)
      val lines = source.mkString
      source.close()
      lines
    }

    // Splits lines by semi-colon
    def splitFile(lines:String):List[String] = {
        
      val splitLines = lines.split(";").toList
      splitLines.map(x => x.trim)
      splitLines
    }

    // Searchs query for keywords.  Removes keyword lines.
    def queryParser(query: String): String = {
      var lines = query.split(" ").toList

      for(line <- lines){
        if (line.contains("--")) {
          lines = lines.filter(x => !x.contains("--"))
        }
      }

      "tet"


    }

    //search string for keyword, if found then get the value after the keywords
    //returns the value as a String
    def getValue(keyword:String, line:String):String = {
      val regex = ("""(?i)""" + keyword + """\s*:\s*(.*)""").r
      val regex(value) = line
      value
    }


    def test(){
      val contents = readFile("src/main/scala/sql/test.sql")

      val split = splitFile(contents)
      println(split)

      val name = getValue("Name", split(0))
    }




}
