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

// class Song_List {
// }

object songsearch {
	def main(args: Array[String]) {
		val lyrics = "Oh Yeah Oh Yeah Kanye Yeah"
		val aSong = new Song("Good Problems", "Kanye", lyrics)
	}
}