package vista;

import java.util.ArrayList;
import java.util.Scanner;

import controlador.ClienteController;
import modelo.Cliente;

public class Main {

	static ClienteController cc = new ClienteController();

	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);
		int menuBucle = -1;
		int menu = -1;

		while (menuBucle == -1) {
			System.out.println("Elige una opción:\n1. " + "Seleccionar todos los clientes\n2."
					+ " Seleccionar cliente por Id\n3." + " Seleccionar cliente por Id de responsable\n4."
					+ " Insertar cliente\n5." + " Actualizar nombre de cliente\n6." + " Borrar cliente\n0. Salir");

			switch (menu = sc.nextInt()) {
			case 1:
				selectAll();
				break;
			case 2:
				selectByIdCliente();
				break;
			case 3:
				selectByIdResponsable();
				break;
			case 4:
				insertarCliente();
				break;
			case 5:
				actualizarNombreCliente();
				break;
			case 6:
				borrarCliente();
				break;
			case 0:
				exit();
				break;

			}

		}

	}

	public static void clear() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}

	public static void selectAll() {

		ArrayList<Cliente> clientes = cc.SelectAll();
		int contadorClientes = 0;
		clear();
		for (Cliente c : clientes) {
			contadorClientes++;
			System.out.println("Cliente " + contadorClientes + "\n" + c);
		}

		System.out.println("--------------------------");
		System.out.println("--------------------------");

	}

	public static void selectByIdCliente() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el Id del cliente");
		Cliente c = cc.SelectByIdCliente(sc.nextInt());
		clear();
		System.out.println(c);
		System.out.println("--------------------------");
		System.out.println("--------------------------");

	}

	public static void selectByIdResponsable() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el Id del responsable");
		ArrayList<Cliente> clientes = cc.SelectByIdResponsable(sc.nextInt());
		clear();
		int contadorClientes = 0;
		for (Cliente c : clientes) {
			contadorClientes++;
			System.out.println("Cliente " + contadorClientes + "\n" + c);
		}
		System.out.println("--------------------------");
		System.out.println("--------------------------");

	}

	public static void insertarCliente() {

		Scanner scInt = new Scanner(System.in);
		Scanner scStr = new Scanner(System.in);

		System.out.println("Introduce el Id del cliente");
		int idCliente = scInt.nextInt();
		System.out.println("Introduce el nombre del cliente");
		String nombre = scStr.nextLine();
		System.out.println("Introduce la direccion del cliente");
		String direccion = scStr.nextLine();
		System.out.println("Introduce el telefono del cliente");
		int telefono = scInt.nextInt();
		System.out.println("Introduce el Id del responsable");
		int idResponsable = scInt.nextInt();

		cc.InsertCliente(idCliente, nombre, direccion, telefono, idResponsable);
		clear();
		System.out.println("--------------------------");
		System.out.println("Cliente insertado con exito");
		System.out.println("--------------------------");

	}

	public static void actualizarNombreCliente() {

		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Introduce el nuevo nombre del cliente");
		String nombre = sc.nextLine();
		System.out.println("Introduce el Id del cliente a modificar");
		int IdCliente = sc2.nextInt();
		cc.UpdateCliente(IdCliente, nombre);
		clear();
		System.out.println("-----------------------------");
		System.out.println("Cliente actualizado con exito");
		System.out.println("-----------------------------");
	}

	public static void borrarCliente() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el Id del cliente a borrar");
		cc.DeleteCliente(sc.nextInt());
		clear();
		System.out.println("--------------------------");
		System.out.println("Cliente borrado con exito");
		System.out.println("--------------------------");

	}

	public static void exit() throws InterruptedException {
		// clear();
		System.out.println("Saliendo del programa ");
		for (int i = 0; i < 8; i++) {
			System.out.print(".");
			Thread.sleep(500);

		}
		System.out.println();
		System.out.println("Programa finalizado");
		System.exit(1);
	}
}
