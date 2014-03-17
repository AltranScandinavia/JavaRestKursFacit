package se.altran.restkurs.main;

import se.altran.restkurs.actor.ActorServiceImpl;
import se.altran.restkurs.actor.ActorService;
import se.altran.restkurs.movie.MovieService;
import se.altran.restkurs.movie.MovieServiceImpl;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;


public class DomainModule extends AbstractModule {
	
	private MovieService movieService;
	private ActorService actorService;
	
	public DomainModule(MovieService movieService) {
		this.movieService = movieService;
		actorService = new ActorServiceImpl();
	}
	public DomainModule(ActorService actorService) {
		this.actorService = actorService;
		movieService = new MovieServiceImpl();
	}
	
	public DomainModule() {
		movieService = new MovieServiceImpl();
		actorService = new ActorServiceImpl();
	}
	
    @Override
    protected void configure() {
    	
    }    
    
    @Provides @Singleton
    private MovieService provideIMovieService() {
    	return movieService;
    }
    
    @Provides @Singleton
    private ActorService provideIActorService() {
    	return actorService;
    }
}