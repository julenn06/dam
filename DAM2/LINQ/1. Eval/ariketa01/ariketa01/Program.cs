namespace ariketak01
{
    internal class Programa
    {
        static void Main(string[] args)
        {
            var pets = new[] {
                              new Pet(1, "Hannibal", PetType.Fish, 1.1f),
                              new Pet(2, "Anthony", PetType.Cat, 2f),
                              new Pet(3, "Ed", PetType.Cat, 0.7f),
                              new Pet(4, "Taiga", PetType.Dog, 35f),
                              new Pet(5, "Rex", PetType.Dog, 40f),
                              new Pet(6, "Lucky", PetType.Dog, 5f),
                              new Pet(7, "Storm", PetType.Cat, 0.9f),
                              new Pet(8, "Nyan", PetType.Cat, 2.2f)
                          };

            Pet pet;
            for (int i = 0; i < pets.Length; i++)
            {
                pet = pets[i];
                Console.WriteLine($"{pet.Id}: {pet.Name} ({pet.Type}) - {pet.Weight}kg");
            }

            int id;
            do
            {
                Console.WriteLine("Elige un animal");
                string? input = Console.ReadLine();
                if (string.IsNullOrWhiteSpace(input) || !int.TryParse(input, out id))
                {
                    Console.WriteLine("Introduce un número válido.");
                    id = -1;
                }
            } while (id == -1);

            var selectedPet = pets.FirstOrDefault(p => p.Id == id);
            Console.WriteLine(selectedPet);

            for (int i = 0; i < pets.Length; i++)
            {
                if (id == pets[i].Id)
                {
                    Console.WriteLine($"El animal que has elegido es: {pets[i].Name} ({pets[i].Type}) - {pets[i].Weight}kg");
                }
            }
        }
    }
}
