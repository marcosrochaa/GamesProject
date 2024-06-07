package br.com.marc.games_project.modelo

data class InfoGame  (val info: InfoApiShark){
    override fun toString(): String {
        return info.toString()
    }
}