export default function albumView(album) {
    return `
        <main class="main-content">
            <section class="album-library">
                <header class="album-library-header">
                    <h2 class="album-library-header-???">${album.title}</h2>
                    <h3 class="album-library-header-???">${album.techStack}</h3>
                </header>    
                <section class="album-songs">
                    ${
                        album.songs.map(song => {
                            return `
                                <div class="song">
                                    <h3 class="song-title">${song.title}</h3>
                                    <input type="hidden" class="sum_field" value="${song.summary}">
                                </div>    
                            `
                        }).join("")
                    }
                </section>
                <div class="NewSongDiv">
                    <input type="text" placeholder="Song Name" class="songNameInput" \>
                    <input type="text" placeholder="Song Description" class="songDescriptionInput" \>

                    <button class="addSongButton">Add Song</button>
                </div>

                <a class="back-navigation">back to album listings</a>
            </section>
        </main>            
    `
}