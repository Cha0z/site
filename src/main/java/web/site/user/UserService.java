package web.site.user;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class UserService {
    private static UserService instance;

    private final HashMap<Long, User> contacts = new HashMap<>();
    private HashMap<Integer, Integer> numbersOfVisitsInHour = new HashMap<>();
    private long nextId = 0;

    public UserService() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
            instance.ensureTestData();
            instance.findAllInformatinAboutVisits();
        }
        return instance;
    }


    public synchronized List<User> findAll() {
        return findAll(null);
    }

    public void ensureTestData() {
        if (findAll().isEmpty()) {
            final String[] names = new String[]{"Gabrielle Patel", "Brian Robinson", "Eduardo Haugen",
                    "Koen Johansen", "Alejandro Macdonald", "Angel Karlsson", "Yahir Gustavsson", "Haiden Svensson",
                    "Emily Stewart", "Corinne Davis", "Ryann Davis", "Yurem Jackson", "Kelly Gustavsson",
                    "Eileen Walker", "Katelyn Martin", "Israel Carlsson", "Quinn Hansson", "Makena Smith",
                    "Danielle Watson", "Leland Harris", "Gunner Karlsen", "Jamar Olsson", "Lara Martin",
                    "Ann Andersson", "Remington Andersson", "Rene Carlsson", "Elvis Olsen", "Solomon Olsen",
                    "Jaydan Jackson", "Bernard Nilsen"};
            Random r = new Random(0);
            for (String name : names) {
                String[] split = name.split(" ");
                User c = new User();
                c.setName(split[0]);
                c.setSurname(split[1]);

                c.setStatus(UserStatus.values()[r.nextInt(UserStatus.values().length)]);
                c.setActivity(Activity.values()[r.nextInt(Activity.values().length)]);
                int daysOld = 0 - r.nextInt(10);
                int hoursOld = 0 - r.nextInt(10);
                c.setLastDateAndTime
                        (LocalDateTime.now().plusDays(daysOld).plusHours(hoursOld));
                save(c);
            }
        }
    }

    public synchronized void save(User user) {
        if (user.getId() == null) {
            user.setId(nextId++);
        }
        try {
            user = user.clone();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        contacts.put(user.getId(), user);
    }

    public synchronized List<User> findAll(String stringFilter) {
        ArrayList<User> arrayList = new ArrayList<>();
        for (User contact : contacts.values()) {
            try {
                boolean passesFilter = (stringFilter == null || stringFilter.isEmpty())
                        || contact.getId().equals(Long.parseLong(stringFilter));
                if (passesFilter) {
                    arrayList.add(contact.clone());
                }
            } catch (CloneNotSupportedException ignored) {
            }
        }
        arrayList.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));
        return arrayList;
    }

    private HashMap<Integer, Integer> countNumberOfVisitsInHour() {
        HashMap<Integer, Integer> numberOfVisits = new HashMap<>();

        int numberOfHoursInDay = 24;

        for (int currentPositions = 0; currentPositions < numberOfHoursInDay; currentPositions++) {
            int counter = 0;
            for (Map.Entry<Long, User> entry : contacts.entrySet()) {
                if (entry.getValue().getLastSessionTime().getHour() == currentPositions) {
                    counter++;
                }
            }
            numberOfVisits.put(currentPositions, counter);
        }

        return numberOfVisits;
    }

    public synchronized Map<Integer, Integer> getNumberOfVisitsInHour(Integer firstHourPoint, Integer secondHourPoint) {
        int firstIndex;
        int secondIndex;
        Map<Integer, Integer> filtered = new HashMap<>();

        List<Integer> hours = new ArrayList<>(numbersOfVisitsInHour.keySet());
        List<Integer> visits = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : numbersOfVisitsInHour.entrySet()) {
            visits.add(entry.getValue());
        }


        firstIndex = getIndex(firstHourPoint, hours);


        secondIndex = getIndex(secondHourPoint, hours);


        hours = hours.subList(firstIndex, secondIndex);
        visits = visits.subList(firstIndex, secondIndex);


        for (int currentIndex = 0; currentIndex < hours.size(); currentIndex++) {
            filtered.put(hours.get(currentIndex), visits.get(currentIndex));
        }


        return filtered;
    }

    private int getIndex(Integer hour, List<Integer> hours) {
        int index = 0;

        index = hours.indexOf(hour);

        return index;
    }

    private void findAllInformatinAboutVisits() {
        numbersOfVisitsInHour = countNumberOfVisitsInHour();
    }


}
