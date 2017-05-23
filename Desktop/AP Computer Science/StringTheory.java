import cs1.Keyboard;
public class StringTheory
{
	public static void main(String[] args)
	{
		String movie = new String("Batman: the Dark Knight Rises");
		
		//to replace one character with another, use .replace
		//this takes all a's, replaces them with o's
		//String oMovie = movie.replace("a","o");
		
		String oMovie = movie.replace("Knight", "Banana shake");
		oMovie = oMovie.replace("Dark", "happy");
		System.out.println(oMovie);
		
		
		// .indexOf("a") will return the location of the first
		//occurence of "a" inside the string\
		//System.out.println("the first ark is at: " + movie.indexOf("ark"));
	
		//what happens if you look for something that ISNT THERE?!?!?
		//System.out.println( movie.indexOf("6") );
		//this returns -1
	
		/*
		//strings go in normal quotation marks (char was single quotes)
		//use new keyword
		String movie = new String("Pacific Rim 2: $500");
		System.out.println(movie);
		
		//say you really love capital letters
		//you can get an uppercase or lowercase version using .toUpperCase or .toLowerCase()
		//this only affects letters
		System.out.println(movie.toUpperCase());
		System.out.println(movie.toLowerCase());	
	
		//doing these commands does not actually change movie
		System.out.println("movie is: " + movie);
		
		
		
		
		//say we just want part of the String
		// we use .substring to get part of it
		//this gives you characters 0 through 6 NOT including the last one
		String firstWord = movie.substring(0,6);
		System.out.println(firstWord);
		
		//if i want "rim" I need 8 through 11 to get characters 8,9,10
		String rim = movie.substring(8,11);
		System.out.println(rim);
		
		//if i just wanna go from one thing to the end, I sent it ONE number
		// this goes from character 1 all the way to the end
		String ending = movie.substring(1);
		System.out.println(ending);
		
		//say you actually want to change the variable movie
		movie = movie.substring(2);
		System.out.println(movie);
		
		
		
		
		//if I want to do things with a string variable, I need to write like:
		// (variable name).length()
		
		System.out.println("the length of my string is: " + movie.length() );
		
		// you can use charAt to figure out what character is at a certain spot
		//print out the first character
		System.out.println( movie.charAt(1) );
		System.out.println ( movie.charAt(10) );
		//so CS starts counting at 0 so the "11th" character is out of bounds
		System.out.println ( movie.charAt(11) );
		
		//dont do this, it will stab you in the back later
		//String oldmovie = "Casablanca";
			
		System.out.println(movie);
		
		
		//to input a string, you use Keyboard.readString()
		System.out.println("whats uyour name?");
		String name = Keyboard.readString();
		
		System.out.println("hello" + name);
	*/
	
	}
}