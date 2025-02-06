@param java.util.List<com.example.petshop.Domain.Models.Cage> cages
@param java.util.List<com.example.petshop.Domain.Models.Race> races
@param java.util.Map<Integer, java.util.List<String>> animalsInCages

@template.shared.template.layout(content = @`
    <div class="p-6">
    <div class="mb-6">
        <button onclick="document.getElementById('addCageModal').classList.remove('hidden')"
                class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
            Add Cage
        </button>
    </div>
        <div id="addCageModal" class="hidden fixed inset-0 bg-gray-600 bg-opacity-50 overflow-y-auto h-full w-full">
            <div class="relative top-20 mx-auto p-5 border w-96 shadow-lg rounded-md bg-white">
                <div class="mt-3">
                    <h3 class="text-lg font-medium leading-6 text-gray-900">Add New Cage</h3>
                    <form action="/cages" method="post" class="mt-4">
                        <div class="mb-4">
                            <label class="block text-gray-700 text-sm font-bold mb-2">Race</label>
                            <select name="raceId" class="shadow border rounded w-full py-2 px-3" required>
                                @for(com.example.petshop.Domain.Models.Race race : races)
                                    <option value="${race.getId()}">${race.getName()}</option>
                                @endfor
                            </select>
                        </div>
                        <div class="mb-4">
                            <label class="block text-gray-700 text-sm font-bold mb-2">Size</label>
                            <input type="number" name="size" min="1" class="shadow appearance-none border rounded w-full py-2 px-3" required>
                        </div>
                        <div class="flex justify-between">
                            <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
                                Add
                            </button>
                            <button type="button"
                                    onclick="document.getElementById('addCageModal').classList.add('hidden')"
                                    class="bg-gray-500 hover:bg-gray-700 text-white font-bold py-2 px-4 rounded">
                                Cancel
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">

        @for(com.example.petshop.Domain.Models.Cage cage : cages)
            !{double occupancy = animalsInCages.containsKey(cage.getId()) ?
                (animalsInCages.get(cage.getId()).size() * 100.0 / cage.getSize()) : 0;}
            <div class="bg-white rounded-lg shadow-lg p-6 border border-gray-200">
                <div class="flex justify-between items-center mb-4">
                    <h2 class="text-xl font-bold">Cage ${cage.getId()}</h2>
                    <span class="text-sm bg-blue-100 text-blue-800 rounded-full px-3 py-1">
                       Size: ${cage.getSize()}
                   </span>
                </div>

                <div class="mb-4">
                    <div class="w-full bg-gray-200 rounded-full h-2.5">
                        <div class="bg-blue-600 h-2.5 rounded-full" style="width: ${occupancy}%"></div>
                    </div>
                    <p class="text-sm text-gray-600 mt-1">
                        ${String.format("%.1f", occupancy)}% full
                    </p>
                </div>
                <div class="space-y-2">
                    <h3 class="font-semibold">Animals:</h3>
                    @if(animalsInCages.get(cage.getId()) != null && !animalsInCages.get(cage.getId()).isEmpty())
                        @for(String animalName : animalsInCages.get(cage.getId()))
                            <span class="inline-block bg-gray-100 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2">
                               ${animalName}
                           </span>
                        @endfor
                    @else
                        <p class="text-gray-500 italic">No animals</p>
                    @endif
                </div>
            </div>
        @endfor
    </div>
    </div>
`)