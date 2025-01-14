package Aula12.ex1;
import java.lang.Class; 
import java.lang.reflect.*;
import Aula3.ex2.*;
import Aula5.ex3.*;
import java.util.*;

public class ex1 {
	
	public static final Scanner sc = new Scanner(System.in);
	public static final String packages[] = {"aula10.ex1.", "aula10.ex2.", "aula11.ex3.", "aula5.ex3.", "aula3.ex2."};
	public static String className;
	
	public static void main(String[] args)  throws IllegalAccessException, InvocationTargetException{
		do {
			System.out.print("Class name: ");
			className = sc.nextLine();
			
			classDump(0);
		} while (!className.equals(""));
	}
	
	private static void classDump(int repeats) throws IllegalAccessException, InvocationTargetException {
		try
		{
			int opcao ;
			Object obj = init(packages[repeats] + className);
			
			do {
				System.out.println("\n\nMenu:\nClasse " + className);
				System.out.println("\t1 -> listar interfaces da classe");
				System.out.println("\t2 -> listar superclasse da classe");
				System.out.println("\t3 -> listar listar consturtores da classe");
				System.out.println("\t4 -> listar métodos da classe");
				System.out.println("\t5 -> listar atributos da classe");
				System.out.println("\t0 -> escolher outra classe");
				System.out.print("Opção: ");
				opcao = sc.nextInt();
				switch(opcao)
				{
					case 0:
						return;
					case 1:
						interfaceDump(obj);
						break;
					case 2:
						superClassDump(obj);
						break;
					case 3:
						constructorDump(obj);
						break;
					case 4:
						methodDump(obj);
						break;
					case 5:
						fieldDump(obj);
						break;
					default:
						System.out.println("Opção não válida");
						break;
				}
			}while (opcao != 0);
		}
		catch (InstantiationException e)
		{
			System.out.println("Interface ou Classe Abstrata selecionada");
		}
		catch (ClassNotFoundException e)
		{
			classDump(++repeats);
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Class not found");
			System.exit(0);
		}
	}
	
	private static Object init(String className) throws ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException {
		Class<?> classe = Class.forName(className);
		if (Modifier.isAbstract(classe.getModifiers()) || classe.isInterface()) {
			throw new InstantiationException();
		}
		System.out.println("Escolha qual o construtor a utilizar");
		Constructor<?> construtores[] = classe.getDeclaredConstructors();
		int i, j = 0;
		for (Constructor<?> construct: construtores)
		{
			String names[] = construct.getName().split("\\.");
			j++;
			System.out.print(j + "-> " + Modifier.toString(construct.getModifiers()) + " " + names[names.length-1] + " (");

			if (construct.getParameterCount() == 0)
				System.out.print("null)");

			Class<?> types[] = construct.getParameterTypes();
			for (i = 0; i < construct.getParameterCount(); i++)
				System.out.print(types[i].getSimpleName() + " var" + i + (i == construct.getParameterCount()-1 ? ")" : ", "));

			Class<?> exceptions[] = construct.getExceptionTypes();
			System.out.printf(exceptions.length == 0 ? ";\n" : " throws ");
			for (i = 0; i < exceptions.length; i++)
				System.out.print(exceptions[i].getSimpleName() + (i == exceptions.length-1 ? ";\n" : ", "));
		}

		int option = 0;
		do {
			try {
				System.out.print("Construtor: ");
				option = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Opç�o inv�lida.");
			}
		}while (option < 1 || option > construtores.length);

		Constructor<?> pick = construtores[option-1];
		Class<?> vars[] = pick.getParameterTypes();
		List<Object> initializedVars = new ArrayList<>();
		for (Class<?> var : vars)
		{
			initializedVars.add(initVar(var));
		}

		return pick.newInstance(initializedVars.toArray());
	}

	private static Object initVar(Class<?> var)
			throws InstantiationException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
		String type = var.getCanonicalName();
		Object toInit = null;
		do {
			try {
				System.out.print(type + ": ");
				switch (type) {
					case "byte":
						toInit = Byte.parseByte(sc.nextLine());
						break;
					case "char":
						toInit = sc.nextLine().charAt(0);
						break;
					case "short":
						toInit = Short.parseShort(sc.nextLine());
						break;
					case "int":
						toInit = Integer.parseInt(sc.nextLine());
						break;
					case "long":
						toInit = Long.parseLong(sc.nextLine());
						break;
					case "float":
						toInit = Float.parseFloat(sc.nextLine());
						break;
					case "double":
						toInit = Double.parseDouble(sc.nextLine());
						break;
					case "boolean":
						toInit = Boolean.parseBoolean(sc.nextLine());
						break;
					default:
						toInit = init(type);
						break;
				}
			}
			catch (IllegalFormatConversionException e)
			{
				;
			}
		} while (toInit == null);
		return toInit;
	}
	
	private static void constructorDump(Object classe)
	{
		int i;
		Constructor<?>[] construtores = classe.getClass().getConstructors();
		System.out.println("\n->Class Constuctors of " + classe.getClass().getSimpleName() + ":\n");
		for (Constructor<?> construct: construtores)
		{
			System.out.print(Modifier.toString(construct.getModifiers()) + " " 
					+ construct.getName() + " (");
			
			if (construct.getParameterCount() == 0)
				System.out.print("null)");
			
			Class<?> types[] = construct.getParameterTypes();
			for (i = 0; i < construct.getParameterCount(); i++)
				System.out.print(types[i].getSimpleName() + " var" + i + (i == construct.getParameterCount()-1 ? ")" : ", "));
			
			Class<?> exceptions[] = construct.getExceptionTypes();
			System.out.printf(exceptions.length == 0 ? ";\n" : " throws ");
			for (i = 0; i < exceptions.length; i++)
				System.out.print(exceptions[i].getSimpleName() + (i == exceptions.length-1 ? ";\n" : ", "));	
		}
	}
	
	private static void methodDump(Object obj)
	{
		int i;
		Method metodos[] = obj.getClass().getDeclaredMethods();
		System.out.println("\n->Class methods of " + obj.getClass().getSimpleName() + ":\n");
		for (Method method : metodos)
		{
			System.out.print(Modifier.toString(method.getModifiers()) + " " 
					+ method.getReturnType().getSimpleName() + " " 
					+ method.getName() + " (");
			
			if (method.getParameterCount() == 0)
				System.out.print("null)");
			
			Class<?> types[] = method.getParameterTypes();
			for (i = 0; i < method.getParameterCount(); i++)
				System.out.print(types[i].getSimpleName() + " var" + i + (i == method.getParameterCount()-1 ? ")" : ", "));
			
			Class<?> exceptions[] = method.getExceptionTypes();
			System.out.printf(exceptions.length == 0 ? ";\n" : " throws ");
			for (i = 0; i < exceptions.length; i++)
				System.out.print(exceptions[i].getSimpleName() + (i == exceptions.length-1 ? ";\n" : ", "));	
		}
	}
	
	private static void fieldDump(Object obj)
	{
		Field campos[] = obj.getClass().getDeclaredFields();
		System.out.println("\n->Class fields of " + obj.getClass().getSimpleName() + ":\n");
		for(Field field : campos)
			System.out.println(Modifier.toString(field.getModifiers()) + " " 
					+ field.getType().getSimpleName() + " " 
					+ field.getName() + ";");
	}
	
	private static void superClassDump(Object obj)
	{
		int i;
		
		String superClassSName = obj.getClass().getSuperclass().getSimpleName();
		System.out.println("\n->SuperClass of " + obj.getClass().getSimpleName() + " is " + superClassSName);

		Method s_metodos[] = obj.getClass().getSuperclass().getDeclaredMethods();
		System.out.println("\n->Class methods of " + superClassSName + ":\n");
		for (Method method : s_metodos)
		{
			System.out.print(Modifier.toString(method.getModifiers()) + " " 
					+ method.getReturnType().getSimpleName() + " " 
					+ method.getName() + " (");
			
			if (method.getParameterCount() == 0)
				System.out.print("null)");
			
			Class<?> types[] = method.getParameterTypes();
			for (i = 0; i < method.getParameterCount(); i++)
				System.out.print(types[i].getSimpleName() + " var" + i + (i == method.getParameterCount()-1 ? ")" : ", "));
			
			Class<?> exceptions[] = method.getExceptionTypes();
			System.out.printf(exceptions.length == 0 ? ";\n" : " throws ");
			for (i = 0; i < exceptions.length; i++)
				System.out.print(exceptions[i].getSimpleName() + (i == exceptions.length-1 ? ";\n" : ", "));
			
		}

		Field s_campos[] = obj.getClass().getSuperclass().getDeclaredFields();
		System.out.println("\n->Class fields of " + superClassSName + ":\n");
		for(Field field : s_campos)
			System.out.println(Modifier.toString(field.getModifiers()) + " " 
					+ field.getType().getSimpleName() + " " 
					+ field.getName() + ";");
		
		Class<?> s_interfaces[] = obj.getClass().getSuperclass().getInterfaces();
		System.out.println("\n->Class interfaces of " + superClassSName + ":\n");
		for (Class<?> class1 : s_interfaces)
			System.out.println("interface " + class1.getSimpleName());
	}
	
	private static void interfaceDump(Object obj)
	{
		Class<?> interfaces[] = obj.getClass().getInterfaces();
		System.out.println("\n->Class interfaces of " + obj.getClass().getSimpleName() + ":\n");
		for (Class<?> class1 : interfaces)
			System.out.println("interface " + class1.getSimpleName());
	}
	

}
