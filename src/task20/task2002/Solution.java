package com.javarush.task.task20.task2002;

import java.io.*;
import java.nio.Buffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            /*File yourFile = File.createTempFile("your_file_name", null);*/
            File yourFile = new File("C:\\ABC2\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2002\\resources\\file1.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("firstname");
            user1.setLastName("lastname");
            Date date = new Date();
            user1.setBirthDate(date);
            user1.setMale(true);
            user1.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user1);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            /*System.out.println("Oops, something is wrong with the save/load method");*/
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter print = new PrintWriter(outputStream);
            if (users.size() != 0) {
                for (User user :
                        users) {
                    print.write("yes\n");
                    print.write(user.getFirstName() + "\n");
                    print.write(user.getLastName() + "\n");
                    SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy HH:mm:ss:SSS", Locale.ENGLISH);
                    print.write(sdf.format(user.getBirthDate()) + "\n");
                    print.write(String.valueOf(user.isMale()) + "\n");
                    print.write(user.getCountry().getDisplayName() + "\n");
                }
            }
            print.write("no");
            print.close();

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
            while (rd.ready()) {
                if (rd.readLine().equals("yes")) {
                    User user = new User();
                    user.setFirstName(rd.readLine());
                    user.setLastName(rd.readLine());
                    SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy HH:mm:ss:SSS", Locale.ENGLISH);
                    user.setBirthDate(sdf.parse(rd.readLine()));
                    user.setMale(Boolean.valueOf(rd.readLine()).equals(Boolean.TRUE));
                    String country = rd.readLine();
                    switch (country) {
                        case "Ukraine":
                            user.setCountry(User.Country.UKRAINE);
                            break;
                        case "Russia":
                            user.setCountry(User.Country.RUSSIA);
                            break;
                        default:
                            user.setCountry(User.Country.OTHER);
                            break;
                    }
                    users.add(user);
                }
            }
            rd.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
