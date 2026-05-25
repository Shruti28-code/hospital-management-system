// package com.hospital.ui;
// import javafx.application.Application;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.*;
// import javafx.scene.layout.*;
// import javafx.stage.Stage;

// public class MainApp extends Application {

//     @Override
//     public void start(Stage stage) {

//         // ── TOP BAR ──────────────────────────────────────────────
//         HBox topBar = new HBox();
//         topBar.setPadding(new Insets(16, 24, 16, 24));
//         topBar.setStyle("-fx-background-color: #1a73e8;");
//         topBar.setAlignment(Pos.CENTER_LEFT);

//         Label title = new Label("🏥  Hospital Management System");
//         title.setStyle("-fx-text-fill: white; -fx-font-size: 18px; -fx-font-weight: bold;");

//         topBar.getChildren().add(title);

//         // ── STAT CARDS ROW ───────────────────────────────────────
//         HBox statsRow = new HBox(16);
//         statsRow.setPadding(new Insets(20, 24, 0, 24));

//         statsRow.getChildren().addAll(
//                 statCard("👥 Total Patients", "1,284", "#e3f2fd", "#1565c0"),
//                 statCard("📅 Appointments", "48", "#e8f5e9", "#2e7d32"),
//                 statCard("🛏 Beds Occupied", "73%", "#fff8e1", "#f57f17"),
//                 statCard("🩺 Doctors On Duty", "22", "#f3e5f5", "#6a1b9a"));

//         // ── PATIENT TABLE ────────────────────────────────────────
//         VBox tableCard = new VBox(10);
//         tableCard.setPadding(new Insets(16));
//         tableCard.setStyle(
//                 "-fx-background-color: white;" +
//                         "-fx-border-color: #e0e0e0;" +
//                         "-fx-border-radius: 8;" +
//                         "-fx-background-radius: 8;");

//         Label tableTitle = new Label("Recent Patients");
//         tableTitle.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #333;");

//         TableView<String[]> table = new TableView<>();
//         table.setPrefHeight(200);
//         table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

//         table.getColumns().addAll(
//                 makeColumn("ID", 0),
//                 makeColumn("Name", 1),
//                 makeColumn("Department", 2),
//                 makeColumn("Status", 3));

//         table.getItems().addAll(
//                 new String[] { "#101", "Rahul Patil", "Cardiology", "Stable" },
//                 new String[] { "#102", "Sunita Mehta", "Orthopaedics", "Observation" },
//                 new String[] { "#103", "Arjun Kumar", "General", "Stable" },
//                 new String[] { "#104", "Priya Desai", "Neurology", "Critical" },
//                 new String[] { "#105", "Vikram Shah", "Paediatrics", "Stable" });

//         tableCard.getChildren().addAll(tableTitle, table);

//         // ── APPOINTMENT LIST ─────────────────────────────────────
//         VBox apptCard = new VBox(10);
//         apptCard.setPadding(new Insets(16));
//         apptCard.setStyle(
//                 "-fx-background-color: white;" +
//                         "-fx-border-color: #e0e0e0;" +
//                         "-fx-border-radius: 8;" +
//                         "-fx-background-radius: 8;");

//         Label apptTitle = new Label("Today's Appointments");
//         apptTitle.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #333;");
//         apptCard.getChildren().add(apptTitle);

//         String[][] appointments = {
//                 { "2:00 PM", "Meera Joshi", "Dr. Kapoor" },
//                 { "2:30 PM", "Anil Rao", "Dr. Sharma" },
//                 { "3:00 PM", "Nisha Gupta", "Dr. Verma" },
//                 { "3:45 PM", "Deepak Singh", "Dr. Iyer" },
//         };

//         for (String[] a : appointments) {
//             HBox row = new HBox(12);
//             row.setPadding(new Insets(6, 0, 6, 0));
//             row.setStyle("-fx-border-color: #f0f0f0; -fx-border-width: 0 0 1 0;");
//             row.setAlignment(Pos.CENTER_LEFT);

//             Label time = new Label(a[0]);
//             time.setStyle("-fx-text-fill: #1a73e8; -fx-font-weight: bold; -fx-font-size: 12px; -fx-min-width: 65;");

//             Label name = new Label(a[1] + "  ·  " + a[2]);
//             name.setStyle("-fx-text-fill: #333; -fx-font-size: 12px;");

//             row.getChildren().addAll(time, name);
//             apptCard.getChildren().add(row);
//         }

//         // ── BOTTOM ROW (table + appointments side by side) ───────
//         HBox bottomRow = new HBox(16);
//         bottomRow.setPadding(new Insets(20, 24, 24, 24));
//         HBox.setHgrow(tableCard, Priority.ALWAYS);
//         apptCard.setPrefWidth(300);
//         bottomRow.getChildren().addAll(tableCard, apptCard);

//         // ── ROOT LAYOUT ──────────────────────────────────────────
//         VBox root = new VBox();
//         root.setStyle("-fx-background-color: #f5f5f5;");
//         root.getChildren().addAll(topBar, statsRow, bottomRow);

//         Scene scene = new Scene(root, 900, 580);
//         stage.setTitle("Hospital Management System");
//         stage.setScene(scene);
//         stage.show();
//     }

//     // Helper: stat card
//     private VBox statCard(String label, String value, String bg, String fg) {
//         VBox card = new VBox(8);
//         card.setPadding(new Insets(16));
//         card.setStyle(
//                 "-fx-background-color: " + bg + ";" +
//                         "-fx-background-radius: 8;");
//         HBox.setHgrow(card, Priority.ALWAYS);

//         Label lbl = new Label(label);
//         lbl.setStyle("-fx-font-size: 12px; -fx-text-fill: " + fg + ";");

//         Label val = new Label(value);
//         val.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: " + fg + ";");

//         card.getChildren().addAll(lbl, val);
//         return card;
//     }

//     // Helper: table column
//     private TableColumn<String[], String> makeColumn(String title, int index) {
//         TableColumn<String[], String> col = new TableColumn<>(title);
//         col.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()[index]));
//         col.setStyle("-fx-font-size: 12px;");
//         return col;
//     }

//     public static void main(String[] args) {
//         launch();
//     }
// }



package com.hospital.ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainApp extends Application {

        private final TableView<String[]> table = new TableView<>();

        private final ObservableList<String[]> patientList = FXCollections.observableArrayList();

        @Override
        public void start(Stage stage) {

                // ───────────────── TOP BAR ─────────────────
                HBox topBar = new HBox();

                topBar.setPadding(new Insets(16));
                topBar.setAlignment(Pos.CENTER_LEFT);

                topBar.setStyle(
                                "-fx-background-color: #1a73e8;");

                Label title = new Label("🏥 Hospital Management System");

                title.setStyle(
                                "-fx-text-fill: white;" +
                                                "-fx-font-size: 20px;" +
                                                "-fx-font-weight: bold;");

                topBar.getChildren().add(title);

                // ───────────────── FORM SECTION ─────────────────

                VBox formCard = new VBox(12);

                formCard.setPadding(new Insets(20));

                formCard.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-background-radius: 10;");

                Label formTitle = new Label("Add Patient");

                formTitle.setStyle(
                                "-fx-font-size: 16px;" +
                                                "-fx-font-weight: bold;");

                TextField nameField = new TextField();
                nameField.setPromptText("Patient Name");

                TextField deptField = new TextField();
                deptField.setPromptText("Department");

                ComboBox<String> statusBox = new ComboBox<>();

                statusBox.getItems().addAll(
                                "Stable",
                                "Critical",
                                "Observation");

                statusBox.setPromptText("Select Status");

                Button addBtn = new Button("Save Patient");

                addBtn.setStyle(
                                "-fx-background-color: #1a73e8;" +
                                                "-fx-text-fill: white;" +
                                                "-fx-font-weight: bold;");

                formCard.getChildren().addAll(
                                formTitle,
                                nameField,
                                deptField,
                                statusBox,
                                addBtn);

                // ───────────────── TABLE SECTION ─────────────────

                VBox tableCard = new VBox(10);

                tableCard.setPadding(new Insets(20));

                tableCard.setStyle(
                                "-fx-background-color: white;" +
                                                "-fx-background-radius: 10;");

                Label tableTitle = new Label("Patients");

                tableTitle.setStyle(
                                "-fx-font-size: 16px;" +
                                                "-fx-font-weight: bold;");

                table.setPrefHeight(400);

                table.setColumnResizePolicy(
                                TableView.CONSTRAINED_RESIZE_POLICY);

                table.getColumns().addAll(
                                makeColumn("ID", 0),
                                makeColumn("Name", 1),
                                makeColumn("Department", 2),
                                makeColumn("Status", 3));

                table.setItems(patientList);

                tableCard.getChildren().addAll(
                                tableTitle,
                                table);

                // ───────────────── BUTTON ACTION ─────────────────

                addBtn.setOnAction(e -> {

                        String name = nameField.getText();
                        String department = deptField.getText();
                        String status = statusBox.getValue();

                        if (name.isEmpty() ||
                                        department.isEmpty() ||
                                        status == null) {

                                showAlert(
                                                "Error",
                                                "Please fill all fields");

                                return;
                        }

                        boolean success = savePatient(name, department, status);

                        if (success) {

                                showAlert(
                                                "Success",
                                                "Patient Added Successfully");

                                nameField.clear();
                                deptField.clear();
                                statusBox.setValue(null);

                                loadPatients();
                        }
                });

                // ───────────────── MAIN LAYOUT ─────────────────

                HBox content = new HBox(20);

                content.setPadding(new Insets(20));

                formCard.setPrefWidth(300);

                HBox.setHgrow(
                                tableCard,
                                Priority.ALWAYS);

                content.getChildren().addAll(
                                formCard,
                                tableCard);

                VBox root = new VBox();

                root.setStyle(
                                "-fx-background-color: #f5f5f5;");

                root.getChildren().addAll(
                                topBar,
                                content);

                Scene scene = new Scene(root, 1000, 600);

                stage.setTitle("Hospital Management System");

                stage.setScene(scene);

                stage.show();

                // Load database data
                loadPatients();
        }

        // ───────────────── LOAD PATIENTS ─────────────────

        private void loadPatients() {

                patientList.clear();

                new Thread(() -> {

                        try {

                                URL url = new URL("http://localhost:8080/patients");

                                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                                connection.setRequestMethod("GET");

                                BufferedReader reader = new BufferedReader(
                                                new InputStreamReader(
                                                                connection.getInputStream()));

                                StringBuilder response = new StringBuilder();

                                String line;

                                while ((line = reader.readLine()) != null) {
                                        response.append(line);
                                }

                                reader.close();

                                String json = response.toString();

                                System.out.println(json);

                                // remove [ ]
                                json = json.substring(1, json.length() - 1);

                                if (json.trim().isEmpty()) {
                                        return;
                                }

                                // split multiple patients
                                String[] patients = json.split("\\},\\{");

                                for (String patient : patients) {

                                        patient = patient.replace("{", "");
                                        patient = patient.replace("}", "");
                                        patient = patient.replace("\"", "");

                                        String[] fields = patient.split(",");

                                        String id = "";
                                        String name = "";
                                        String department = "";
                                        String status = "";

                                        for (String field : fields) {

                                                String[] pair = field.split(":");

                                                String key = pair[0];
                                                String value = pair[1];

                                                switch (key) {

                                                        case "id":
                                                                id = value;
                                                                break;

                                                        case "name":
                                                                name = value;
                                                                break;

                                                        case "department":
                                                                department = value;
                                                                break;

                                                        case "status":
                                                                status = value;
                                                                break;
                                                }
                                        }

                                        String[] row = {
                                                        id,
                                                        name,
                                                        department,
                                                        status
                                        };

                                        Platform.runLater(() -> patientList.add(row));
                                }

                        } catch (Exception e) {
                                e.printStackTrace();
                        }

                }).start();
        }
        // ───────────────── SAVE PATIENT ─────────────────

        private boolean savePatient(
                        String name,
                        String department,
                        String status) {

                try {

                        URL url = new URL(
                                        "http://localhost:8080/patients");

                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                        connection.setRequestMethod("POST");

                        connection.setRequestProperty(
                                        "Content-Type",
                                        "application/json");

                        connection.setDoOutput(true);

                        String json = """
                                        {
                                          "name":"%s",
                                          "department":"%s",
                                          "status":"%s"
                                        }
                                        """.formatted(
                                        name,
                                        department,
                                        status);

                        OutputStream os = connection.getOutputStream();

                        os.write(json.getBytes());

                        os.flush();
                        os.close();

                        int responseCode = connection.getResponseCode();

                        return responseCode == 200 ||
                                        responseCode == 201;

                } catch (Exception e) {

                        e.printStackTrace();

                        return false;
                }
        }

        // ───────────────── TABLE COLUMN ─────────────────

        private TableColumn<String[], String> makeColumn(
                        String title,
                        int index) {

                TableColumn<String[], String> col = new TableColumn<>(title);

                col.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(
                                data.getValue()[index]));

                return col;
        }

        // ───────────────── ALERT ─────────────────

        private void showAlert(
                        String title,
                        String message) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle(title);

                alert.setHeaderText(null);

                alert.setContentText(message);

                alert.showAndWait();
        }

        public static void main(String[] args) {
                launch();
        }
}