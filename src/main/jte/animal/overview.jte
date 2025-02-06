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
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Actions</th>
            </tr>
            </thead>
            <tbody class="bg-white divide-y divide-gray-200">
            @for(com.example.petshop.Domain.Models.Animal animal : animals)
                <tr class="hover:bg-gray-50">
                    <td class="px-6 py-4 whitespace-nowrap">${animal.getName()}</td>
                    <td class="px-6 py-4 whitespace-nowrap">${raceNames.get(animal.getRaceId())}</td>
                    <td class="px-6 py-4 whitespace-nowrap">${animal.getBirthYear()}</td>
                    <td class="px-6 py-4 whitespace-nowrap">
                        <form action="/delete-animal" method="POST" class="inline">
                            <input type="hidden" name="id" value="${animal.getId()}">
                            <button type="submit" class="text-red-600 hover:text-red-900">
                                <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                                    <path fill-rule="evenodd" d="M9 2a1 1 0 00-.894.553L7.382 4H4a1 1 0 000 2v10a2 2 0 002 2h8a2 2 0 002-2V6a1 1 0 100-2h-3.382l-.724-1.447A1 1 0 0011 2H9zM7 8a1 1 0 012 0v6a1 1 0 11-2 0V8zm5-1a1 1 0 00-1 1v6a1 1 0 102 0V8a1 1 0 00-1-1z" clip-rule="evenodd" />
                                </svg>
                            </button>
                        </form>
                    </td>
                </tr>
            @endfor
            </tbody>
        </table>
        <a href="/add-animal" class="mt-4 inline-block bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded">Add Animal</a>
    </div>
`)