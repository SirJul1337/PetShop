@param java.util.List<com.example.petshop.Domain.Models.Animal> animals
@param java.util.List<com.example.petshop.Domain.Models.Race> races
@param java.util.List<com.example.petshop.Domain.Models.Cage> cages

@template.shared.template.layout(content = @`
    <div class="p-4">
        <h1 class="text-2xl font-bold mb-6">Add Animal</h1>
        <form action="/animals" method="post" class="max-w-md">
            <div class="mb-4">
                <label class="block text-gray-700 text-sm font-bold mb-2">Name</label>
                <input type="text" name="name" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" required>
            </div>
            <div class="mb-4">
                <label class="block text-gray-700 text-sm font-bold mb-2">Birth Year</label>
                <input type="number" name="birthYear" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" required>
            </div>
            <div class="mb-4">
                <label class="block text-gray-700 text-sm font-bold mb-2">Race</label>
                <select name="raceId" class="shadow border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" required>
                    @for(com.example.petshop.Domain.Models.Race race : races)
                        <option value="${race.getId()}">${race.getName()}</option>
                    @endfor
                </select>
            </div>
            <div class="mb-6">
                <label class="block text-gray-700 text-sm font-bold mb-2">Cage</label>
                <select name="cageId" class="shadow border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" required>
                    @for(com.example.petshop.Domain.Models.Cage cage : cages)
                        <option value="${cage.getId()}">${cage.getId()}</option>
                    @endfor
                </select>
            </div>
            <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">Add Animal</button>
        </form>
    </div>
`)