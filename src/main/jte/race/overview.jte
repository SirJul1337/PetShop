@param java.util.List<com.example.petshop.Domain.Models.Race> races

@template.shared.template.layout(content = @`
    <div class="p-4">
        <h1 class="text-2xl font-bold mb-4">Races</h1>
        <table class="min-w-full divide-y divide-gray-200">
            <thead class="bg-gray-50">
            <tr>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">ID</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Name</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Max Age</th>
            </tr>
            </thead>
            <tbody class="bg-white divide-y divide-gray-200">
            @for(com.example.petshop.Domain.Models.Race race : races)
                <tr class="hover:bg-gray-50">
                    <td class="px-6 py-4 whitespace-nowrap">${race.getId()}</td>
                    <td class="px-6 py-4 whitespace-nowrap">${race.getName()}</td>
                    <td class="px-6 py-4 whitespace-nowrap">${race.getMaxAge()}</td>
                </tr>
            @endfor
            </tbody>
        </table>
        <a href="/add-species" class="mt-4 inline-block bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded">Add Species</a>
    </div>
`)