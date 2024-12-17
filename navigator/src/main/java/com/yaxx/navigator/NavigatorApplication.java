package com.yaxx.navigator;

import com.yaxx.navigator.initializer.Metadata;
import com.yaxx.navigator.interpreter.Project;

import java.lang.reflect.Method;
import java.util.Hashtable;

public class NavigatorApplication {

	public static void main(String[] args) {

		Metadata metadata = new Metadata();

		Hashtable<String, Method> table_metadata = metadata.createOptionsMetadata();

		//Scanner scan = new Scanner(System.in);

		String enter_line = args[0];

		//while (!enter_line.contains("-q")){

			//enter_line = enter_line.replace("nv", "").trim();

			if(enter_line.equals("-c")){

				String command = "createProject";

				Method method = table_metadata.get(command);

				try{
					method.invoke(Project.class, metadata.FOLDER_PROJECTS);
				}catch (Exception e){
					System.out.println(e.getMessage());
				}
			}

			if(enter_line.equals("-l")){

				String command = "listProjects";

				Method method = table_metadata.get(command);

				try{
					method.invoke(Project.class, metadata.FOLDER_PROJECTS);
				}catch (Exception e){
					System.out.println(e.getMessage());
				}

			}

			if(enter_line.contains("-e")){
				String command = "enterProject";

				Method method = table_metadata.get(command);

				String name_project = args[1];

				try{
					method.invoke(Project.class, metadata.FOLDER_PROJECTS, name_project);
				}catch (Exception e){
					System.out.println("Error invoke: " + e.getMessage());
				}
			}

			//enter_line = scan.nextLine();
		//}
	}
}
