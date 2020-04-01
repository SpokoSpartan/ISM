package io.swagger.data.seed;

import io.swagger.data.entity.Comment;
import io.swagger.data.entity.Event;
import io.swagger.data.entity.User;
import io.swagger.data.repository.CommentRepository;
import io.swagger.data.repository.EventRepository;
import io.swagger.data.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Component
public class DatabaseSeed {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final CommentRepository commentRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public DatabaseSeed(UserRepository userRepository, EventRepository eventRepository, CommentRepository commentRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.commentRepository = commentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    private void initDatabase() {
        User userFirst = initUser("user1");
        User userSecond = initUser("user2");
        Event footballEvent = initEvent("Amateur football event", "Wrocław, Traugutta 999", 24,
                "https://images.unsplash.com/photo-1525088068454-ff2c453e50e9?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80",
                "We aim to provide football opportunities For All, regardless of age, gender, ability, race, culture or background. " +
                        "We also pride ourselves on the skill and competitiveness of our leagues, and on our " +
                        "traditions of fair play and respect for opponents and match officials.", userFirst);
        Event basketballEvent = initEvent("Basketball for averyone", "Warcszawa, Warszawska 12", 10,
                "https://images.unsplash.com/photo-1534491159066-2e753c542678?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1352&q=80",
                "We invite everyone who wants to play.", userSecond);
        Comment comment1 = initComment("Is there place for car?", userSecond);
        Comment comment2 = initComment("Yes. Close to the playing field", userFirst);
        addCommentToEvent(footballEvent, comment1);
        addCommentToEvent(footballEvent, comment2);
    }

    private User initUser(String username) {
        User user = new User(username, passwordEncoder.encode(username));
        return userRepository.save(user);
    }

    private Event initEvent(String name, String place, Integer nrOfPlayers, String imageUrl, String additionalInfo, User owner) {
        Event event = new Event(name, place, nrOfPlayers, imageUrl, additionalInfo, owner);
        return eventRepository.save(event);
    }

    private Comment initComment(String content, User user) {
        Comment comment = new Comment(content, user);
        return commentRepository.save(comment);
    }

    private Event addCommentToEvent(Event event, Comment comment) {
        event.addComment(comment);
        return eventRepository.save(event);
    }

}
