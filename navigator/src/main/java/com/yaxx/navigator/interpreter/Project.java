package com.yaxx.navigator.interpreter;

import com.yaxx.navigator.interpreter.model.ProjectMetadata;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Project {

    public static void createProject(String folder){

        String name;
        String description;
        String path;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Name: ");
        name = scanner.nextLine();

        System.out.print("Descritpion: ");
        description = scanner.nextLine();

        System.out.print("Path: ");
        path = scanner.nextLine();

        ProjectMetadata project_metadata = new ProjectMetadata(name, description, path);

        project_metadata.save(folder);
    }

    public static void listProjects(String folder){

        File folder_system = new File(folder);

        List<File> files = List.of(Objects.requireNonNull(folder_system.listFiles()));;

        for(File file : files){

            Scanner scanner;

            try {
                scanner = new Scanner(new File(file.getAbsolutePath()));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            String line = scanner.nextLine();

            String[] line_split = line.split(";");

            String name = line_split[0];
            String description = line_split[1];
            String path = line_split[2];
            int is_delete = Integer.parseInt(line_split[3]);

            ProjectMetadata project_metadata = new ProjectMetadata(name, description, path, is_delete);

            if(is_delete == 0){
                System.out.println();
                project_metadata.show();
            }

        }
    }

    public static void enterProject(String folder, String name_project){

        File folder_system = new File(folder);

        List<File> files = List.of(Objects.requireNonNull(folder_system.listFiles()));;

        for(File file : files){

            Scanner scanner;

            try {
                scanner = new Scanner(new File(file.getAbsolutePath()));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            if(!file.getName().replaceAll(".txt", "").equals(name_project)){
                continue;
            }

            String line = scanner.nextLine();

            String[] line_split = line.split(";");

            String name = line_split[0];
            String description = line_split[1];
            String path = line_split[2];
            int is_delete = Integer.parseInt(line_split[3]);

            ProjectMetadata project_metadata = new ProjectMetadata(name, description, path, is_delete);

            if(is_delete == 1){
                return;
            }

            project_metadata.enter();
        }

    }
}
