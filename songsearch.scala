import scala.collection.mutable.Map

class Song(t: String, a: String) {
	val title: String = t
	val artist: String = a
	var lyrics = Array[String]_
	var word_count = Map.empty[String, Int]


	def count(word: String):String = {
		/* Called .get here to return an option */
		word_count.get(word) match {
			case None => word_count(word) = 1
			case _ => word_count(word) = word_count(word) + 1
		}
		return word
	}

	def add_lyrics(lyrics_input: String) {
		
		//lyrics = lyrics_input.split(" ")
		//lyrics.map(word => count(word));
	}

}

// class Song_List {

// }

object songsearch {

	def main(args: Array[String]) {

	}
}