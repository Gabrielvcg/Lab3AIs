package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.omdb.MovieSearch;

public class OMDbResource {

	private static final String OMDB_API_KEY = "c68bd62c";  // TODO: Change this API KEY for your personal Key
	private static final Logger log = Logger.getLogger(OMDbResource.class.getName());
	
	
	public MovieSearch getMovies(String query) throws UnsupportedEncodingException {

		String texto=URLEncoder.encode(query,"UTF-8");
		String uri="http://www.omdbapi.com/?apikey="+OMDB_API_KEY+"&s="+texto;
		log.log(Level.FINE,"MOVIE URI: "+ uri);
		ClientResource cr= new ClientResource(uri);
		MovieSearch movieSearch=cr.get(MovieSearch.class);
		
	    return movieSearch;
	}
	}
}
