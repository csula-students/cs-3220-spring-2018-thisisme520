/*eslint-env node, jest */

import { GameChart } from '../src/views/chart';
require('@skatejs/ssr/register');
const render = require('@skatejs/ssr');

describe('Chart Component', () => {
    beforeEach(() => {
        window.customElements.define('game-chart', GameChart);
    });

    it('should display empty chart', done => {
        render(new GameChart()).then(html => {
            expect(html).toMatchSnapshot();
            done();
        });
    });

    it('should display chart with bar', done => {
        const chart = new GameChart();
        chart.values = [1, 2, 3];
        render(chart).then(html => {
            expect(html).toMatchSnapshot();
            done();
        });
    });

    it('should be able to update color', done => {
        const chart = new GameChart();
        chart.values = [1, 2, 3];
        render(chart).then(html => {
            expect(html).toMatchSnapshot();
        })
        .then(() => {
            chart.color = '#00ff00';
            return render(chart);
        }).then(html => {
            expect(html).toMatchSnapshot();
            done();
        });
    });
});
