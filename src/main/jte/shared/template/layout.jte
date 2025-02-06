@param gg.jte.Content content
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Pet Shop</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
<nav class="bg-gray-800 mb-6">
    <div class="max-w-7xl mx-auto px-4">
        <div class="flex items-center h-16">
            <a href="/" class="text-white text-xl font-bold">Pet Shop</a>
            <div class="ml-10 flex space-x-4">
                <a href="/" class="text-gray-300 hover:text-white px-3 py-2">Animals</a>
                <a href="/stats" class="text-gray-300 hover:text-white px-3 py-2">Stats</a>
                <a href="/cages" class="text-gray-300 hover:text-white px-3 py-2">Cages</a>
            </div>
        </div>
    </div>
</nav>
<div class="max-w-7xl mx-auto px-4">
    ${content}
</div>
</body>
</html>