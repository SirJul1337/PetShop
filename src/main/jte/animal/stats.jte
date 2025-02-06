@param java.util.Map<String,Long> animalStats

@template.shared.template.layout(content = @`
    <div class="p-4">
        <h1 class="text-2xl font-bold mb-6">Animal Statistics</h1>
        <div class="w-full h-96">
            <canvas id="animalChart"></canvas>
        </div>
    </div>
    <script>
        const data = {
            labels: [@for(var entry : animalStats.entrySet())'${entry.getKey()}',@endfor],
            datasets: [{
                label: 'Number of Animals',
                data: [@for(var entry : animalStats.entrySet())${entry.getValue()},@endfor],
                backgroundColor: '#3B82F6'
            }]
        };

        new Chart(document.getElementById('animalChart'), {
            type: 'bar',
            data: data,
            options: {
                responsive: true,
                maintainAspectRatio: false,
                scales: { y: { beginAtZero: true } }
            }
        });
    </script>
`)