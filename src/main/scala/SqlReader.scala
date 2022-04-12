


object SqlReader{
    // Regex of keywords to search sql file for.
    val keywords = List("^Name", "^Description", "^Type", "^Default", "^Required", "^Example", "^Notes")

    // Returns the file in a string
    def readFile(file:String):List[String] = {
        val source = Source.fromFile(file)
        val lines = source.getLines().toList
        source.close()
        lines.mkString("\n") // return the file as a string
    }

    // Splits lines by semi-colon
    def splitFile(lines:String):List[String] = {
        
        val splitLines = lines.split(";").toList
        splitLines.map(x => x.trim)
        splitLines
    }

    //search string for keyword, if found then get the value after the keywords
    //returns the value as a String
    def getValue(keyword:String, line:String):String = {
        val regex = ("""(?i)""" + keyword + """\s*:\s*(.*)""").r
        val regex(value) = line
        value
    }



}
