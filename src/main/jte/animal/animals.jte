@param java.util.List<com.example.petshop.Domain.Models.Animal> animals
@param java.util.Map<Integer,String> raceNames

@template.shared.template.layout(content = @`
    <div class="p-4">
        <h1 class="text-2xl font-bold mb-4">Animals</h1>
        <table class="min-w-full divide-y divide-gray-200">
            <thead class="bg-gray-50">
            <tr>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Name</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Species</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Birthyear</th>
            </tr>
            </thead>
            <tbody class="bg-white divide-y divide-gray-200">
            @for(com.example.petshop.Domain.Models.Animal animal : animals)
                <tr class="hover:bg-gray-50">
                    <td class="px-6 py-4 whitespace-nowrap">${animal.getName()}</td>
                    <td class="px-6 py-4 whitespace-nowrap">${raceNames.get(animal.getRaceId())}</td>
                    <td class="px-6 py-4 whitespace-nowrap">${animal.getBirthYear()}</td>
                </tr>
            @endfor
            </tbody>
        </table>
        <a href="/add-animal" class="mt-4 inline-block bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded">Add Animal</a>
    </div>
`)