import scala.io.Source

class Song(t: String, a: String, l: String) {
	val title: String = t
	val artist: String = a
	var word_count:Map[String, Int] = Map()
	val lyrics:Array[String] = add_lyrics(l);

	def count(word: String) {
		/* Called .get here to return an option */
		word_count.get(word) match {
			case None => word_count += (word -> 1)
			case _ => word_count += (word -> (word_count(word) + 1))
		}
	}

	def add_lyrics(lyrics_input: String):Array[String] = {
		val lyrics:Array[String] = lyrics_input.split(" ")
		for (word <- lyrics) {
			count(word)
		}
		return lyrics
	}

	def print_lyrics() {
		for (word <- lyrics) {
			println(word + " ")
		}
		println("\n")
	}

}

class Song_List(file_name: String) {
	var songs:Array[Song] = read_data(file_name)
	var word_map:Map[String, Array[Int]] = Map()

	def read_data(file_name: String):Array[Song] = {
		for (line <- Source.fromFile(file_name).getLines()) {
  		println(line)
		}
		return new Array[Song](3)
		//TODO store in word_map		
	}
}

object songsearch {
	def main(args: Array[String]) {
			
		//val data = new Song_List(args(0))


		val lyrics = "Oh Yeah Oh Yeah Kanye Yeah"
		val aSong = new Song("Good Problems", "Kanye", lyrics)

		println("Title: " + aSong.title + "\n")
		println("Artist: " + aSong.artist + "\n")
		println("Lyrics: "); aSong.print_lyrics()
		println("Word Count: " + aSong.word_count.values + "")

		// for (ln <- io.Source.stdin.getLines) println(ln)
		
	}
}