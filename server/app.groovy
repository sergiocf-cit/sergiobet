@RestController
class Service {
    @RequestMapping('/next-matches')
    def nextMatches() {
        def result = []
        result.add([description: 'Botafogo vs Cruzeiro',
                    homeTeamFlag: 'https://www.futwiz.com/assets/img/fifa17/____futbadges/517.png',
                    visitorTeamFlag: 'https://www.futwiz.com/assets/img/fifa17/____futbadges/568.png',
                    scheduledTime: '11:00 18/04/2020'])

        result.add([description: 'Botafogo vs Atlético',
                    homeTeamFlag: 'https://www.futwiz.com/assets/img/fifa17/____futbadges/517.png',
                    visitorTeamFlag: 'https://www.futwiz.com/assets/img/fifa17/____futbadges/1035.png',
                    scheduledTime: '12:00 20/04/2020'])

        result.add([description: 'Atlético vs Cruzeiro',
                    homeTeamFlag: 'https://www.futwiz.com/assets/img/fifa17/____futbadges/1035.png',
                    visitorTeamFlag: 'https://www.futwiz.com/assets/img/fifa17/____futbadges/568.png',
                    scheduledTime: '14:00 23/04/2020'])

        result.add([description: 'Cruzeiro vs Botafogo',
                    homeTeamFlag: 'https://www.futwiz.com/assets/img/fifa17/____futbadges/568.png',
                    visitorTeamFlag: 'https://www.futwiz.com/assets/img/fifa17/____futbadges/517.png',
                    scheduledTime: '11:00 25/04/2020'])

        result.add([description: 'Atlético vs Botafogo',
                    homeTeamFlag: 'https://www.futwiz.com/assets/img/fifa17/____futbadges/1035.png',
                    visitorTeamFlag: 'https://www.futwiz.com/assets/img/fifa17/____futbadges/517.png',
                    scheduledTime: '17:00 30/04/2020'])

        result.add([description: 'Inter vs Liverpool',
                    homeTeamFlag: 'https://www.futwiz.com/assets/img/fifa17/____futbadges/44.png',
                    visitorTeamFlag: 'https://www.futwiz.com/assets/img/fifa17/____futbadges/9.png',
                    scheduledTime: '17:00 30/04/2020'])

        result.add([description: 'PSG vs Liverpool',
                    homeTeamFlag: 'https://www.futwiz.com/assets/img/fifa17/____futbadges/73.png',
                    visitorTeamFlag: 'https://www.futwiz.com/assets/img/fifa17/____futbadges/9.png',
                    scheduledTime: '17:00 30/05/2020'])

        result
    }
}

