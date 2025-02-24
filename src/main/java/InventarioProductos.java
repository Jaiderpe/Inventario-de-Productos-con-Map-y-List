import java.util.*;
public class InventarioProductos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> inventario = new HashMap<>();

        // 1. Pedir la cantidad de categorías
        System.out.print("Ingrese la cantidad de categorías: ");
        int cantidadCategorias = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        // 2. Para cada categoría, pedir productos
        for (int i = 0; i < cantidadCategorias; i++) {
            System.out.print("Ingrese el nombre de la categoría: ");
            String categoria = scanner.nextLine();
            System.out.print("Ingrese la cantidad de productos en " + categoria + ": ");
            int cantidadProductos = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            List<String> productos = new ArrayList<>();
            for (int j = 0; j < cantidadProductos; j++) {
                System.out.print("Ingrese el nombre del producto: ");
                String producto = scanner.nextLine();
                productos.add(producto);
            }
            inventario.put(categoria, productos);
        }

        // 3. Mostrar productos de una categoría específica
        System.out.print("\nIngrese el nombre de la categoría para ver sus productos: ");
        String categoriaBuscar = scanner.nextLine();
        if (inventario.containsKey(categoriaBuscar)) {
            System.out.println("Productos en " + categoriaBuscar + ": " + inventario.get(categoriaBuscar));
        } else {
            System.out.println("Categoría no encontrada.");
        }

        // 4. Agregar un nuevo producto a una categoría existente
        System.out.print("\nIngrese el nombre de la categoría donde desea agregar un producto: ");
        String categoriaAgregar = scanner.nextLine();
        if (inventario.containsKey(categoriaAgregar)) {
            System.out.print("Ingrese el nombre del nuevo producto: ");
            String nuevoProducto = scanner.nextLine();
            inventario.get(categoriaAgregar).add(nuevoProducto);
            System.out.println("Producto agregado exitosamente.");
        } else {
            System.out.println("Categoría no encontrada.");
        }

        // 5. Mostrar la lista completa de categorías y productos
        System.out.println("\nInventario completo:");
        for (Map.Entry<String, List<String>> entry : inventario.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}
