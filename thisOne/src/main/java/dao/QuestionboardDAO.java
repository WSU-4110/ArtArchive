
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Questionboard;

public class QuestionboardDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/artarchive";
    private String jdbcUsername = "root";
    private String jdbcPassword = "DetroitandNewYork#1104";
    private static final String INSERT_QUESTIONS_SQL = "INSERT INTO questionboard  (topic_author, topic_title, topicquestion) VALUES  (?, ?, ?);";
    private static final String SELECT_ALL_QUESTIONS = "SELECT * FROM questionboard";
    private static final String SELECT_SPECIFIC_QUESTION = "SELECT * FROM questionboard WHERE topic_id = ?";
    private static final String DELETE_QUESTIONS = "DELETE FROM QUESTIONBOARD";
    private static final String UPDATE_QUESTIONS = "update QUESTIONBOARD set topic_author = ?,topic_title= ?, topic_question =? where topic_id = ?";

    public QuestionboardDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(this.jdbcURL, this.jdbcUsername, this.jdbcPassword);
        } catch (SQLException var3) {
            var3.printStackTrace();
        } catch (ClassNotFoundException var4) {
            var4.printStackTrace();
        }

        return connection;
    }

    public Questionboard selectquestion(int topic_id) {
        Questionboard question = null;

        try {
            Connection connection = this.getConnection();

            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM questionboard WHERE topic_id = ?");

                try {
                    preparedStatement.setInt(1, topic_id);
                    System.out.println(preparedStatement);

                    String topic_author;
                    String topic_title;
                    String topicquestion;
                    for(ResultSet rs = preparedStatement.executeQuery(); rs.next(); question = new Questionboard(topic_id, topic_author, topic_title, topicquestion)) {
                        topic_author = rs.getString("topic_author");
                        topic_title = rs.getString("topic_title");
                        topicquestion = rs.getString("topicquestion");
                    }
                } catch (Throwable var11) {
                    if (preparedStatement != null) {
                        try {
                            preparedStatement.close();
                        } catch (Throwable var10) {
                            var11.addSuppressed(var10);
                        }
                    }

                    throw var11;
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable var12) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var9) {
                        var12.addSuppressed(var9);
                    }
                }

                throw var12;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var13) {
            this.printSQLException(var13);
        }

        return question;
    }

    public void insertQuestions(Questionboard question) throws SQLException {
        System.out.println("INSERT INTO questionboard  (topic_author, topic_title, topicquestion) VALUES  (?, ?, ?);");

        try {
            Connection connection = this.getConnection();

            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO questionboard  (topic_author, topic_title, topicquestion) VALUES  (?, ?, ?);");

                try {
                    preparedStatement.setString(1, question.getTopic_author());
                    preparedStatement.setString(2, question.getTopic_title());
                    preparedStatement.setString(3, question.getTopicquestion());
                    System.out.println(preparedStatement);
                    preparedStatement.executeUpdate();
                } catch (Throwable var8) {
                    if (preparedStatement != null) {
                        try {
                            preparedStatement.close();
                        } catch (Throwable var7) {
                            var8.addSuppressed(var7);
                        }
                    }

                    throw var8;
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable var9) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var6) {
                        var9.addSuppressed(var6);
                    }
                }

                throw var9;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var10) {
            this.printSQLException(var10);
        }

    }

    private void printSQLException(SQLException ex) {
        Iterator var2 = ex.iterator();

        while(true) {
            Throwable e;
            do {
                if (!var2.hasNext()) {
                    return;
                }

                e = (Throwable)var2.next();
            } while(!(e instanceof SQLException));

            e.printStackTrace(System.err);
            System.err.println("SQLState: " + ((SQLException)e).getSQLState());
            System.err.println("Error Code: " + ((SQLException)e).getErrorCode());
            System.err.println("Message: " + e.getMessage());

            for(Throwable t = ex.getCause(); t != null; t = t.getCause()) {
                System.out.println("Cause: " + t);
            }
        }
    }

    public List<Questionboard> selectAllData() {
        ArrayList questions = new ArrayList();

        try {
            Connection connection = this.getConnection();

            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM questionboard");

                try {
                    System.out.println(preparedStatement);
                    ResultSet rs = preparedStatement.executeQuery();

                    while(rs.next()) {
                        int topic_id = rs.getInt("topic_id");
                        String topic_author = rs.getString("topic_author");
                        String topic_title = rs.getString("topic_title");
                        String topicquestion = rs.getString("topicquestion");
                        questions.add(new Questionboard(topic_id, topic_author, topic_title, topicquestion));
                    }
                } catch (Throwable var11) {
                    if (preparedStatement != null) {
                        try {
                            preparedStatement.close();
                        } catch (Throwable var10) {
                            var11.addSuppressed(var10);
                        }
                    }

                    throw var11;
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable var12) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var9) {
                        var12.addSuppressed(var9);
                    }
                }

                throw var12;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var13) {
            this.printSQLException(var13);
        }

        return questions;
    }

    public boolean deletequestion(int topic_id) throws SQLException {
        Connection connection = this.getConnection();

        boolean rowDeleted;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM QUESTIONBOARD");

            try {
                statement.setInt(1, topic_id);
                rowDeleted = statement.executeUpdate() > 0;
            } catch (Throwable var9) {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (Throwable var8) {
                        var9.addSuppressed(var8);
                    }
                }

                throw var9;
            }

            if (statement != null) {
                statement.close();
            }
        } catch (Throwable var10) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Throwable var7) {
                    var10.addSuppressed(var7);
                }
            }

            throw var10;
        }

        if (connection != null) {
            connection.close();
        }

        return rowDeleted;
    }

    public boolean editquestion(Questionboard question) throws SQLException {
        Connection connection = this.getConnection();

        boolean rowUpdated;
        try {
            PreparedStatement statement = connection.prepareStatement("update QUESTIONBOARD set topic_author = ?,topic_title= ?, topic_question =? where topic_id = ?");

            try {
                statement.setString(1, question.getTopic_author());
                statement.setString(2, question.getTopic_title());
                statement.setString(3, question.getTopicquestion());
                statement.setInt(4, question.getTopic_id());
                rowUpdated = statement.executeUpdate() > 0;
            } catch (Throwable var9) {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (Throwable var8) {
                        var9.addSuppressed(var8);
                    }
                }

                throw var9;
            }

            if (statement != null) {
                statement.close();
            }
        } catch (Throwable var10) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Throwable var7) {
                    var10.addSuppressed(var7);
                }
            }

            throw var10;
        }

        if (connection != null) {
            connection.close();
        }

        return rowUpdated;
    }
}
